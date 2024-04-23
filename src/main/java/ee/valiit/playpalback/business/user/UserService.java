package ee.valiit.playpalback.business.user;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.event.dto.EventInfoRequest;
import ee.valiit.playpalback.business.participant.dto.EventsParticipatedInfo;
import ee.valiit.playpalback.business.participant.dto.ParticipantCountInfo;
import ee.valiit.playpalback.business.user.dto.UserProfileInfoExtended;
import ee.valiit.playpalback.business.user.dto.UserProfileInfoRequest;
import ee.valiit.playpalback.domain.event.event.Event;
import ee.valiit.playpalback.domain.event.event.EventMapper;
import ee.valiit.playpalback.domain.event.event.EventRepository;
import ee.valiit.playpalback.domain.image.profileimage.ProfileImage;
import ee.valiit.playpalback.domain.image.profileimage.ProfileImageRepository;
import ee.valiit.playpalback.domain.location.city.City;
import ee.valiit.playpalback.domain.location.city.CityMapper;
import ee.valiit.playpalback.domain.location.city.CityRepository;
import ee.valiit.playpalback.domain.participant.participant.ParticipantRepository;
import ee.valiit.playpalback.domain.participant.role.Role;
import ee.valiit.playpalback.domain.participant.role.RoleRepository;
import ee.valiit.playpalback.domain.user.gender.Gender;
import ee.valiit.playpalback.domain.user.gender.GenderRepository;
import ee.valiit.playpalback.domain.user.profile.Profile;
import ee.valiit.playpalback.domain.user.profile.ProfileMapper;
import ee.valiit.playpalback.domain.user.profile.ProfileRepository;
import ee.valiit.playpalback.domain.user.user.User;
import ee.valiit.playpalback.domain.user.user.UserMapper;
import ee.valiit.playpalback.domain.user.user.UserRepository;
import ee.valiit.playpalback.infrastructure.exception.ForbiddenException;
import ee.valiit.playpalback.infrastructure.validation.ValidationService;
import ee.valiit.playpalback.util.StringConverter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ee.valiit.playpalback.infrastructure.error.Error.USER_EXISTS;

@Service
@Data
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CityRepository cityRepository;
    private final GenderRepository genderRepository;
    private final ProfileRepository profileRepository;
    private final ParticipantRepository participantRepository;
    private final RoleRepository roleRepository;
    private final ProfileImageRepository profileImageRepository;
    private final EventRepository eventRepository;

    private final EventMapper eventMapper;
    private final UserMapper userMapper;
    private final CityMapper cityMapper;
    private final ProfileMapper profileMapper;


    public boolean getUserNameExists(String userName) {
        return userRepository.usernameExists(userName);
    }


    @Transactional
    public void addUser(UserProfileInfoRequest request) {
        validateUsername(request);
        User user = createAndSaveUser(request);
        Profile profile = createAndSaveProfile(request, user);
        handleProfileImage(request, profile);
    }

    public UserProfileInfoExtended getUserData(Integer userId) {
        Profile profile = profileRepository.findProfileByUserIdAndStatus(userId, Status.DELETED);
        String imageData = getImageData(userId);
        UserProfileInfoExtended userProfileInfoExtended = profileMapper.toUserProfileInfoExtended(profile);
        userProfileInfoExtended.setImageData(imageData);
        return userProfileInfoExtended;
    }


    public void editUserProfile(Integer userId, UserProfileInfoRequest userProfileInfoRequest) {
        Profile profile = getProfile(userId, userProfileInfoRequest);
        handleUsernameUpdate(userProfileInfoRequest, profile);
        updateProfileCity(userProfileInfoRequest, profile);
        updateProfileGender(userProfileInfoRequest, profile);
        handlePasswordUpdate(userProfileInfoRequest, profile);
        updateProfileImage(userId, userProfileInfoRequest);
        profileRepository.save(profile);
    }

    public EventsParticipatedInfo getEventCountByUserId(Integer userId) {
        long participantCountByUserId = participantRepository.countParticipantsForPastEvents(userId, Status.ACTIVE, Status.ACTIVE);
        return new EventsParticipatedInfo(userId, participantCountByUserId);
    }

    private void validateUsername(UserProfileInfoRequest userProfileInfoRequest) {
        boolean usernameExists = userRepository.usernameExists(userProfileInfoRequest.getUsername());
        ValidationService.validateUserNameIsAvailable(usernameExists);
    }


    private void handleProfileImage(UserProfileInfoRequest request, Profile profile) {
        if (hasProfileImage(request)) {
            createAndSaveProfileImage(request, profile);

        }
    }

    private static boolean hasProfileImage(UserProfileInfoRequest request) {
        return !request.getProfileImage().isEmpty();
    }

    private void createAndSaveProfileImage(UserProfileInfoRequest request, Profile profile) {
        ProfileImage profileImage = createProfileImage(request, profile);
        profileImageRepository.save(profileImage);
    }

    private static ProfileImage createProfileImage(UserProfileInfoRequest request, Profile profile) {
        ProfileImage profileImage = new ProfileImage();
        profileImage.setProfile(profile);
        profileImage.setImageData(StringConverter.stringToBytes(request.getProfileImage()));
        return profileImage;
    }

    private Profile createAndSaveProfile(UserProfileInfoRequest request, User user) {
        Profile profile = createProfile(request, user);
        profileRepository.save(profile);
        return profile;
    }

    private Profile createProfile(UserProfileInfoRequest request, User user) {
        Gender gender = genderRepository.getReferenceById(request.getGenderId());
        City city = cityRepository.getReferenceById(request.getCityId());
        Profile profile = profileMapper.toProfile(request);
        profile.setUser(user);
        profile.setGender(gender);
        profile.setCity(city);
        return profile;
    }

    private User createAndSaveUser(UserProfileInfoRequest request) {
        User user = createUser(request);
        userRepository.save(user);
        return user;
    }

    private User createUser(UserProfileInfoRequest request) {
        Role role = roleRepository.getReferenceById(2);
        User user = userMapper.toUser(request);
        user.setRole(role);
        return user;
    }

    private void updateProfileCity(UserProfileInfoRequest userProfileInfoRequest, Profile profile) {
        if (!haveSameCityId(userProfileInfoRequest, profile)) {
            City city = cityRepository.getReferenceById(userProfileInfoRequest.getCityId());
            profile.setCity(city);
        }
    }

    private static boolean haveSameCityId(UserProfileInfoRequest userProfileInfoRequest, Profile profile) {
        return profile.getCity().getId().equals(userProfileInfoRequest.getCityId());
    }

    private void updateProfileGender(UserProfileInfoRequest userProfileInfoRequest, Profile profile) {
        if (!haveSameGenderId(userProfileInfoRequest, profile)) {
            Gender gender = genderRepository.getReferenceById(userProfileInfoRequest.getGenderId());
            profile.setGender(gender);
        }
    }

    private static boolean haveSameGenderId(UserProfileInfoRequest userProfileInfoRequest, Profile profile) {
        return profile.getGender().getId().equals(userProfileInfoRequest.getGenderId());
    }

    private static void updateProfilePassword(UserProfileInfoRequest userProfileInfoRequest, Profile profile) {
        String newPassword = userProfileInfoRequest.getPassword();
        if (newPassword != null && !newPassword.isEmpty()) {
            profile.getUser().setPassword(newPassword);
        }
    }

    private static boolean passwordEmpty(UserProfileInfoRequest userProfileInfoRequest) {
        return !userProfileInfoRequest.getPassword().isEmpty();
    }


    private static boolean haveSamePassword(UserProfileInfoRequest userProfileInfoRequest, Profile profile) {
        String existingPassword = profile.getUser().getPassword();
        String newPassword = userProfileInfoRequest.getPassword();
        // Check if both passwords are empty or if they match
        return (existingPassword.isEmpty() && newPassword.isEmpty()) || existingPassword.equals(newPassword);
    }

    private void updateProfileImage(Integer userId, UserProfileInfoRequest userProfileInfoRequest) {
        String profileImageData = userProfileInfoRequest.getProfileImage();
        Profile profile = profileRepository.getReferenceById(userId);

            profileImageRepository.deleteByProfileId(profile.getId());

        if (!profileImageData.isEmpty()) {
            ProfileImage profileImage = new ProfileImage();
            profileImage.setProfile(profile);
            profileImage.setImageData(StringConverter.stringToBytes(profileImageData));
            profileImageRepository.save(profileImage);
        }

        }
    private String getImageData(Integer userId) {
        Optional<ProfileImage> optionalProfileImage = profileImageRepository.findProfileImageByUserId(userId);

        String imageData = "";
        if (optionalProfileImage.isPresent()) {
            imageData = StringConverter.bytesToString(optionalProfileImage.get().getImageData());
        }
        return imageData;
    }


    private Profile getProfile(Integer userId, UserProfileInfoRequest userProfileInfoRequest) {
        Profile profile = profileRepository.getReferenceById(userId);
        profileMapper.editProfile(userProfileInfoRequest, profile);
        return profile;
    }

    private static void handlePasswordUpdate(UserProfileInfoRequest userProfileInfoRequest, Profile profile) {
        if (passwordEmpty(userProfileInfoRequest) && !haveSamePassword(userProfileInfoRequest, profile)) {
            updateProfilePassword(userProfileInfoRequest, profile);
        }
    }

    private void handleUsernameUpdate(UserProfileInfoRequest userProfileInfoRequest, Profile profile) {
        String existingUsername = profile.getUser().getUsername();
        String newUsername = userProfileInfoRequest.getUsername();
        if (!existingUsername.equals(newUsername)) {

            if (!newUsername.isEmpty()) {
                boolean usernameExists = userRepository.usernameExists(newUsername);
                if (usernameExists) {
                    throw new ForbiddenException(USER_EXISTS.getMessage(), USER_EXISTS.getErrorCode());
                } else {
                    profile.getUser().setUsername(newUsername);
                }
            } else {
                throw new IllegalArgumentException("New username cannot be empty");
            }
        }
        ;
    }
}
