package ee.valiit.playpalback.domain.user.profile;

import ee.valiit.playpalback.business.user.dto.UserProfileInfoRequest;
import ee.valiit.playpalback.domain.user.user.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {




    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "password", target = "user.password")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "interestedIn", target = "interestedIn")
    @Mapping(source = "introduction", target = "introduction")
//    @Mapping(source = "", target = "userImange")

    Profile toprofile(UserProfileInfoRequest userProfileInfoRequest);
}