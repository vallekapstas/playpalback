package ee.valiit.playpalback.business.user;

import ee.valiit.playpalback.business.user.dto.UserProfileInfoRequest;
import ee.valiit.playpalback.domain.location.city.City;
import ee.valiit.playpalback.domain.location.city.CityMapper;
import ee.valiit.playpalback.domain.location.city.CityRepository;
import ee.valiit.playpalback.domain.user.gender.Gender;
import ee.valiit.playpalback.domain.user.gender.GenderRepository;
import ee.valiit.playpalback.domain.user.profile.Profile;
import ee.valiit.playpalback.domain.user.profile.ProfileMapper;
import ee.valiit.playpalback.domain.user.profile.ProfileRepository;
import ee.valiit.playpalback.domain.user.user.User;
import ee.valiit.playpalback.domain.user.user.UserMapper;
import ee.valiit.playpalback.domain.user.user.UserRepository;
import ee.valiit.playpalback.infrastructure.validation.ValidationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CityRepository cityRepository;
    private final ProfileRepository profileRepository;
    private final GenderRepository genderRepository;

    private final UserMapper userMapper;
    private final CityMapper cityMapper;
    private final ProfileMapper profileMapper;

    public boolean getUserNameExists(String userName) {
        return userRepository.usernameExists(userName);
    }


   @Transactional
    public void addUser(UserProfileInfoRequest userProfileInfoRequest) {
        boolean usernameExists = userRepository.usernameExists(userProfileInfoRequest.getUsername());
        ValidationService.validateUsernameExists(usernameExists);



        City city = cityRepository.getReferenceById(userProfileInfoRequest.getCityId());
        Profile profileCityId = profileMapper.toprofile(userProfileInfoRequest);
        profileCityId.setCity(city);

        //    @Mapping(source = "username", target = "user.username")
        Gender gender = genderRepository.getReferenceById(userProfileInfoRequest.getGenderId());
        Profile profileGenderId = profileMapper.toprofile(userProfileInfoRequest);
        profileGenderId.setGender(gender);

        profileRepository.save(profileGenderId);
        profileRepository.save(profileCityId);




    }
}
