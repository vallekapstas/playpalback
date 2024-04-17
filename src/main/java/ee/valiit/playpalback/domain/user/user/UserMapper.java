package ee.valiit.playpalback.domain.user.user;

import ee.valiit.playpalback.business.login.dto.LoginResponse;
import ee.valiit.playpalback.business.user.dto.UserProfileInfoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    @Mapping(source = "role.id", target = "roleId")
    LoginResponse toLoginResponse(User user);


    @Mapping(source = "username",target = "username")
    @Mapping(source = "password",target = "password")
    User touser(UserProfileInfoRequest userProfileInfoRequest);


}