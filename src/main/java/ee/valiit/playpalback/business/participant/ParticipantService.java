package ee.valiit.playpalback.business.participant;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.participant.dto.ParticipantInfo;
import ee.valiit.playpalback.domain.participant.participant.Participant;
import ee.valiit.playpalback.domain.participant.participant.ParticipantMapper;
import ee.valiit.playpalback.domain.participant.participant.ParticipantRepository;
import ee.valiit.playpalback.domain.user.profile.Profile;
import ee.valiit.playpalback.domain.user.profile.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final ProfileRepository profileRepository;

    private final ParticipantMapper participantMapper;

    public ParticipantInfo getParticipantOfEvent(Integer eventId, Integer userId) {
        ParticipantInfo participantInfo = handleParticipantInfoRequest(eventId, userId);
        getAndSetParticipantFirstNameAndLastName(userId, participantInfo);
        return participantInfo;

    }

    private ParticipantInfo handleParticipantInfoRequest(Integer eventId, Integer userId) {
        Participant participant = participantRepository.findParticipantByEventIdAndUserId(eventId, userId);
        return participantMapper.toParticipantInfo(participant);
    }

    private void getAndSetParticipantFirstNameAndLastName(Integer userId, ParticipantInfo participantInfo) {
        Profile profile = profileRepository.findProfileByUserIdAndStatus(userId, Status.DELETED);
        participantInfo.setFirstName(profile.getFirstName());
        participantInfo.setLastName(profile.getLastName());
    }
}
