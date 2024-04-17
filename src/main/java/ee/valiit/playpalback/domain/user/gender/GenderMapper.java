package ee.valiit.playpalback.domain.user.gender;

import ee.valiit.playpalback.business.gender.dto.GenderInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenderMapper {


    @Mapping(source = "name", target = "genderName")
    @Mapping(source = "id", target = "genderId")
    GenderInfo toGenderInfo(Gender gender);

    List<GenderInfo> toGenderInfos(List<Gender> genders);

}