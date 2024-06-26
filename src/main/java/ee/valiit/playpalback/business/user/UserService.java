package ee.valiit.playpalback.business.user;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.participant.dto.EventsParticipatedInfo;
import ee.valiit.playpalback.business.user.dto.UserProfileInfoEdit;
import ee.valiit.playpalback.business.user.dto.UserProfileInfoExtended;
import ee.valiit.playpalback.business.user.dto.UserProfileInfoRequest;
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
    private final RoleRepository roleRepository;
    private final EventRepository eventRepository;
    private final GenderRepository genderRepository;
    private final ProfileRepository profileRepository;
    private final ParticipantRepository participantRepository;
    private final ProfileImageRepository profileImageRepository;

    private final UserMapper userMapper;
    private final CityMapper cityMapper;
    private final EventMapper eventMapper;
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


    public void editUserProfile(Integer userId, UserProfileInfoEdit userProfileInfoEdit) {
        Profile profile = getProfile(userId, userProfileInfoEdit);
        handleUsernameUpdate(userProfileInfoEdit, profile);
        updateProfileCity(userProfileInfoEdit, profile);
        updateProfileGender(userProfileInfoEdit, profile);
        updateProfileImage(userId, userProfileInfoEdit);
        profileRepository.save(profile);
    }

    public EventsParticipatedInfo getPastEventCountByUserId(Integer userId) {
        long countParticipationForPastEvents = participantRepository.countParticipationForPastEvents(userId, Status.ACTIVE, Status.ACTIVE);
        return new EventsParticipatedInfo(userId, countParticipationForPastEvents);
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

    private void updateProfileCity(UserProfileInfoEdit UserProfileInfoEdit, Profile profile) {
        if (!haveSameCityId(UserProfileInfoEdit, profile)) {
            City city = cityRepository.getReferenceById(UserProfileInfoEdit.getCityId());
            profile.setCity(city);
        }
    }

    private static boolean haveSameCityId(UserProfileInfoEdit userProfileInfoRequest, Profile profile) {
        return profile.getCity().getId().equals(userProfileInfoRequest.getCityId());
    }

    private void updateProfileGender(UserProfileInfoEdit UserProfileInfoEdit, Profile profile) {
        if (!haveSameGenderId(UserProfileInfoEdit, profile)) {
            Gender gender = genderRepository.getReferenceById(UserProfileInfoEdit.getGenderId());
            profile.setGender(gender);
        }
    }

    private static boolean haveSameGenderId(UserProfileInfoEdit UserProfileInfoEdit, Profile profile) {
        return profile.getGender().getId().equals(UserProfileInfoEdit.getGenderId());
    }



    private void updateProfileImage(Integer userId, UserProfileInfoEdit userProfileInfoRequest) {
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


    private Profile getProfile(Integer userId, UserProfileInfoEdit UserProfileInfoEdit) {
        Profile profile = profileRepository.getReferenceById(userId);
        profileMapper.editProfile(UserProfileInfoEdit, profile);
        return profile;
    }



    private void handleUsernameUpdate(UserProfileInfoEdit userProfileInfoRequest, Profile profile) {
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

    }
}
