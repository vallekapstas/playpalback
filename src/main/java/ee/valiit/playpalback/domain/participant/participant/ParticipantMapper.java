package ee.valiit.playpalback.domain.participant.participant;

import ee.valiit.playpalback.business.participant.dto.ParticipantInfo;
import ee.valiit.playpalback.domain.participant.participant.Participant;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParticipantMapper {
    @Mapping(source = "id", target = "participantId")
    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "userName")
    @Mapping(source = "status", target = "status")
    ParticipantInfo toParticipantInfo(Participant participant);
}