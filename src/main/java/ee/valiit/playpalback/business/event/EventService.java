package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.event.dto.EventInfo;
import ee.valiit.playpalback.business.event.dto.EventList;
import ee.valiit.playpalback.domain.event.event.Event;
import ee.valiit.playpalback.domain.event.event.EventMapper;
import ee.valiit.playpalback.domain.event.event.EventRepository;
import ee.valiit.playpalback.domain.image.eventimage.EventImage;
import ee.valiit.playpalback.domain.image.eventimage.EventImageRepository;
import ee.valiit.playpalback.domain.participant.participant.ParticipantRepository;
import ee.valiit.playpalback.domain.user.profile.Profile;
import ee.valiit.playpalback.domain.user.profile.ProfileMapper;
import ee.valiit.playpalback.domain.user.profile.ProfileRepository;
import ee.valiit.playpalback.util.StringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final ProfileRepository profileRepository;
    private final EventImageRepository eventImageRepository;
    private final ParticipantRepository participantRepository;

    private final EventMapper eventMapper;
    private final ProfileMapper profileMapper;

    public EventInfo getEventData(Integer eventId) {
        EventInfo eventData = handleEventInfoRequest(eventId);
        getAndSetHostFirstNameAndLastName(eventData);
        getAndSetEventImage(eventId, eventData);
        getAndSetParticipantCount(eventId, eventData);

        return eventData;
    }

    public List<EventList> getEvents() {
//        Event eventsRequest = eventMapper.toEventFilteringAndSorting(params);
        List<Event> events = eventRepository.findEventsBy(Status.DELETED, LocalDate.now());
        List<EventList> eventsList = eventMapper.toEventsList(events);
        return eventsList;
    }

    private EventInfo handleEventInfoRequest(Integer eventId) {
        Event event = eventRepository.getEventBy(eventId, Status.DELETED);
        return eventMapper.toEventInfo(event);
    }

    private void getAndSetEventImage(Integer eventId, EventInfo eventData) {
        String imageData = getImageData(eventId);
        eventData.setEventImage(imageData);
    }

    private void getAndSetHostFirstNameAndLastName(EventInfo eventData) {
        Profile profile = profileRepository.findProfileByUserIdAndStatus(eventData.getHostId(), Status.DELETED);
        eventData.setHostFirstName(profile.getFirstName());
        eventData.setHostLastName(profile.getLastName());
    }

    private String getImageData(Integer eventId) {
        Optional<EventImage> optionalEventImage = eventImageRepository.findEventImageByEventId(eventId);

        String imageData = "";
        if (optionalEventImage.isPresent()) {
            imageData = StringConverter.bytesToString(optionalEventImage.get().getImageData());
        }

        return imageData;
    }

    private void getAndSetParticipantCount(Integer eventId, EventInfo eventData) {
        long participantCount = participantRepository.countByEventIdAndEventStatus(eventId, Status.ACTIVE);
        eventData.setParticipantCount(participantCount);
    }
}
