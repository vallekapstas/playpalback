package ee.valiit.playpalback.business.Participant;

import ee.valiit.playpalback.business.Participant.dto.ParticipantCountInfo;
import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.domain.participant.participant.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    public ParticipantCountInfo getParticipantCountByEventId(Integer eventId) {
        long participantCount = participantRepository.countByEventIdAndEventStatus(eventId, Status.ACTIVE);
        return new ParticipantCountInfo(eventId, participantCount);
    }
}
