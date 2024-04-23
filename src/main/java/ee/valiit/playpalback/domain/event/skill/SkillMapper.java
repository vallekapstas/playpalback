package ee.valiit.playpalback.domain.event.skill;

import ee.valiit.playpalback.business.skill.dto.SkillInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SkillMapper {


    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "id")
    SkillInfo toSkillInfo(Skill skill);

    List<SkillInfo> toSkillInfos(List<Skill> skills);


}