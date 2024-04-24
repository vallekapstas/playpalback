package ee.valiit.playpalback.domain.user.profile;

import ee.valiit.playpalback.business.user.dto.UserProfileInfoEdit;
import ee.valiit.playpalback.business.user.dto.UserProfileInfoExtended;
import ee.valiit.playpalback.business.user.dto.UserProfileInfoRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {


    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "interestedIn", target = "interestedIn")
    @Mapping(source = "introduction", target = "introduction")
    Profile toProfile(UserProfileInfoRequest userProfileInfoRequest);


    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.role.id", target = "roleId")
    @Mapping(source = "gender.id", target = "genderId")
    @Mapping(source = "gender.name", target = "genderName")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "city.county.name", target = "countyName")
    @Mapping(source = "city.county.country.name", target = "countryName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "interestedIn", target = "interestedIn")
    @Mapping(source = "introduction", target = "introduction")
    UserProfileInfoExtended toUserProfileInfoExtended(Profile profile);



    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "interestedIn", target = "interestedIn")
    @Mapping(source = "introduction", target = "introduction")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Profile editProfile(UserProfileInfoEdit UserProfileInfoEdit, @MappingTarget Profile profile);


}