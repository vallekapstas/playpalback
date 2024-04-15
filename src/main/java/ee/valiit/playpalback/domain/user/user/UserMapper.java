package ee.valiit.playpalback.domain.user.user;

import ee.valiit.playpalback.business.login.dto.LoginResponse;
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

}