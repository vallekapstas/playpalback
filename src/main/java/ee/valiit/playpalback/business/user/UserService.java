package ee.valiit.playpalback.business.user;

import ee.valiit.playpalback.domain.image.profileimage.ProfileImage;
import ee.valiit.playpalback.domain.image.profileimage.ProfileImageRepository;
import ee.valiit.playpalback.business.user.dto.UserProfileInfoRequest;
import ee.valiit.playpalback.domain.location.city.City;
import ee.valiit.playpalback.domain.location.city.CityMapper;
import ee.valiit.playpalback.domain.location.city.CityRepository;
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
import ee.valiit.playpalback.infrastructure.validation.ValidationService;
import ee.valiit.playpalback.util.StringConverter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CityRepository cityRepository;
    private final GenderRepository genderRepository;
    private final ProfileRepository profileRepository;

    private final UserMapper userMapper;
    private final CityMapper cityMapper;
    private final ProfileMapper profileMapper;
    private final RoleRepository roleRepository;
    private final ProfileImageRepository profileImageRepository;

    public boolean getUserNameExists(String userName) {
        return userRepository.usernameExists(userName);
    }


    @Transactional
    public void addUser(UserProfileInfoRequest request) {
        boolean usernameExists = userRepository.usernameExists(request.getUsername());
        ValidationService.validateUserNameIsAvailable(usernameExists);
        User user = createAndSaveUser(request);
        Profile profile = createAndSaveProfile(request, user);
        handleProfileImage(request, profile);
    }

    private void handleProfileImage(UserProfileInfoRequest request, Profile profile) {
        if (hasProfileImage(request)) {
            createAndSaveProfileImage(request, profile);

        }
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

    private static boolean hasProfileImage(UserProfileInfoRequest request) {
        return !request.getProfileImage().isEmpty();
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
}
