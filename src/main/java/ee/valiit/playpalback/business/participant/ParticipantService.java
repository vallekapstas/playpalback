package ee.valiit.playpalback.business.participant;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.participant.dto.AddParticipantToEventRequest;
import ee.valiit.playpalback.business.participant.dto.ParticipantCountInfo;
import ee.valiit.playpalback.business.participant.dto.ParticipantInfo;
import ee.valiit.playpalback.domain.event.event.Event;
import ee.valiit.playpalback.domain.event.event.EventMapper;
import ee.valiit.playpalback.domain.event.event.EventRepository;
import ee.valiit.playpalback.domain.participant.participant.Participant;
import ee.valiit.playpalback.domain.participant.participant.ParticipantMapper;
import ee.valiit.playpalback.domain.participant.participant.ParticipantRepository;
import ee.valiit.playpalback.domain.user.profile.Profile;
import ee.valiit.playpalback.domain.user.profile.ProfileRepository;
import ee.valiit.playpalback.domain.user.user.User;
import ee.valiit.playpalback.domain.user.user.UserMapper;
import ee.valiit.playpalback.domain.user.user.UserRepository;
import ee.valiit.playpalback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    private final EventMapper eventMapper;
    private final UserMapper userMapper;
    private final ParticipantMapper participantMapper;
    private final EventRepository eventRepository;

    public ParticipantInfo getParticipantOfEvent(Integer eventId, Integer userId) {
        ParticipantInfo participantInfo = handleParticipantInfoRequest(eventId, userId);
        getAndSetParticipantFirstNameAndLastName(userId, participantInfo);
        return participantInfo;

    }

    public ParticipantCountInfo getParticipantCountByEventId(Integer eventId) {
        long participantCount = participantRepository.countByEventIdAndEventStatus(eventId, Status.ACTIVE);
        return new ParticipantCountInfo(eventId, participantCount);
    }

    public void rejectParticipant(Integer participantId) {
        Participant participant = participantRepository.getReferenceById(participantId);
        participant.setStatus(Status.REJECTED);
        participantRepository.save(participant);
    }

    public void deleteParticipant(Integer participantId) {
        Participant participant = participantRepository.getReferenceById(participantId);
        participantRepository.delete(participant);
    }

    public void addParticipant(AddParticipantToEventRequest addRequest) {
        User userId = userRepository.getReferenceById(addRequest.getUserId());
        Event eventId = eventRepository.getReferenceById(addRequest.getEventId());
        Participant participant = participantMapper.toParticipant(addRequest);
        participant.setEvent(eventId);
        participant.setUser(userId);
        participantRepository.save(participant);

    }

    public void acceptParticipantToEvent(Integer participantId) {
        Participant participant = participantRepository.getReferenceById(participantId);
        participant.setStatus(Status.ACTIVE);
        participantRepository.save(participant);
    }

    public List<ParticipantInfo> getListOfParticipants(Integer eventId, String status) {
        List<Participant> participants;
        if (status != null) {
            // If status parameter is provided, filter by status
            participants = participantRepository.findParticipantListFiltered(eventId, status);
        } else {
            // If status parameter is not provided, get all participants for the event
            participants = participantRepository.findParticipantList(eventId);
        }
        return enrichParticipantInfo(participants);
    }

    private List<ParticipantInfo> enrichParticipantInfo(List<Participant> participants) {
        List<ParticipantInfo> participantInfos = participantMapper.toParticipantInfos(participants);
        for (ParticipantInfo participantInfo : participantInfos) {
            Profile profile = profileRepository.getReferenceById(participantInfo.getUserId());
            participantInfo.setFirstName(profile.getFirstName());
            participantInfo.setLastName(profile.getLastName());
        }
        return participantInfos;

    }

    private ParticipantInfo handleParticipantInfoRequest(Integer eventId, Integer userId) {
        Participant participant = participantRepository.findParticipantByEventIdAndUserId(eventId, userId);
        validateParticipant(participant);
        return participantMapper.toParticipantInfo(participant);
    }

    private void validateParticipant(Participant participant) {
        boolean participantNotFound = participant == null;
        ValidationService.validateParticipantExists(participantNotFound);
    }

    private void getAndSetParticipantFirstNameAndLastName(Integer userId, ParticipantInfo participantInfo) {
        Profile profile = profileRepository.findProfileByUserIdAndStatus(userId, Status.DELETED);
        participantInfo.setFirstName(profile.getFirstName());
        participantInfo.setLastName(profile.getLastName());
    }
}
