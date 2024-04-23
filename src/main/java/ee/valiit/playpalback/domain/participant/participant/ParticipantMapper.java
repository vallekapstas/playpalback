package ee.valiit.playpalback.domain.participant.participant;

import ee.valiit.playpalback.business.user.dto.ParticipantInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParticipantMapper {


}