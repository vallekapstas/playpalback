package ee.valiit.playpalback.business.participant;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.participant.dto.ParticipantInfo;
import ee.valiit.playpalback.domain.participant.participant.Participant;
import ee.valiit.playpalback.domain.participant.participant.ParticipantMapper;
import ee.valiit.playpalback.domain.participant.participant.ParticipantRepository;
import ee.valiit.playpalback.domain.user.profile.Profile;
import ee.valiit.playpalback.domain.user.profile.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParticipantService {
    private static ParticipantRepository participantRepository;
    private static ProfileRepository profileRepository;

    private static ParticipantMapper participantMapper;

    public ParticipantInfo getParticipantOfEvent(Integer eventId, Integer userId) {
        ParticipantInfo participantInfo = handleParticipantInfoRequest(eventId, userId);
        getAndSetParticipantFirstNameAndLastName(userId, participantInfo);
        return participantInfo;

    }

    private static void getAndSetParticipantFirstNameAndLastName(Integer userId, ParticipantInfo participantInfo) {
        Profile profile = profileRepository.findProfileByUserIdAndStatus(userId, Status.DELETED);
        participantInfo.setFirstName(profile.getFirstName());
        participantInfo.setLastName(profile.getLastName());
    }

    private static ParticipantInfo handleParticipantInfoRequest(Integer eventId, Integer userId) {
        Participant participant = participantRepository.findParticipantByEventIdAndUserId(eventId, userId);
        ParticipantInfo participantInfo = participantMapper.toParticipantInfo(participant);
        return participantInfo;
    }
}
