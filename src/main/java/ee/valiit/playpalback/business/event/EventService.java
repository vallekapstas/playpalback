package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.event.dto.CreateEventInfo;
import ee.valiit.playpalback.business.event.dto.EventInfoRequest;
import ee.valiit.playpalback.domain.event.event.Event;
import ee.valiit.playpalback.domain.event.event.EventMapper;
import ee.valiit.playpalback.domain.event.event.EventRepository;
import ee.valiit.playpalback.domain.event.skill.Skill;
import ee.valiit.playpalback.domain.event.skill.SkillRepository;
import ee.valiit.playpalback.domain.image.eventimage.EventImage;
import ee.valiit.playpalback.domain.image.eventimage.EventImageMapper;
import ee.valiit.playpalback.domain.image.eventimage.EventImageRepository;
import ee.valiit.playpalback.domain.location.city.City;
import ee.valiit.playpalback.domain.location.city.CityRepository;
import ee.valiit.playpalback.domain.location.location.Location;
import ee.valiit.playpalback.domain.location.location.LocationMapper;
import ee.valiit.playpalback.domain.location.location.LocationRepository;
import ee.valiit.playpalback.domain.participant.participant.ParticipantRepository;
import ee.valiit.playpalback.domain.user.profile.Profile;
import ee.valiit.playpalback.domain.user.profile.ProfileMapper;
import ee.valiit.playpalback.domain.user.profile.ProfileRepository;
import ee.valiit.playpalback.domain.user.user.User;
import ee.valiit.playpalback.domain.user.user.UserRepository;
import ee.valiit.playpalback.util.StringConverter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class EventService {

    private final UserRepository userRepository;
    private final CityRepository cityRepository;
    private final EventRepository eventRepository;
    private final SkillRepository skillRepository;
    private final ProfileRepository profileRepository;
    private final LocationRepository locationRepository;
    private final EventImageRepository eventImageRepository;
    private final ParticipantRepository participantRepository;

    private final EventMapper eventMapper;
    private final EventImageMapper eventImageMapper;
    private final ProfileMapper profileMapper;
    private final LocationMapper locationMapper;

    public EventInfoRequest getEventData(Integer eventId) {
        EventInfoRequest eventData = handleEventInfoRequest(eventId);
        getAndSetHostFirstNameAndLastName(eventData);
        getAndSetEventImage(eventId, eventData);
        getAndSetParticipantCount(eventId, eventData);

        return eventData;
    }




    @Transactional
    public void createEvent(CreateEventInfo createEventInfo) {
        Event event = eventMapper.toEvent(createEventInfo);
        User user = userRepository.getReferenceById(createEventInfo.getHostId());
        event.setUser(user);
        Skill skill = skillRepository.getReferenceById(createEventInfo.getSkillId());
        event.setSkill(skill);
        Location locations = locationMapper.toLocations(createEventInfo);
        City city = cityRepository.getReferenceById(createEventInfo.getCityId());
        locations.setCity(city);
        locationRepository.save(locations);
        event.setLocation(locations);
        eventRepository.save(event);
        EventImage eventImage = eventImageMapper.toEventImage(createEventInfo);
        eventImage.setEvent(event);
        eventImageRepository.save(eventImage);
    }

    private EventInfoRequest handleEventInfoRequest(Integer eventId) {
        Event event = eventRepository.getEventBy(eventId, Status.DELETED);
        return eventMapper.toEventInfo(event);
    }

    private void getAndSetEventImage(Integer eventId, EventInfoRequest eventData) {
        String imageData = getImageData(eventId);
        eventData.setEventImage(imageData);
    }

    private void getAndSetHostFirstNameAndLastName(EventInfoRequest eventData) {
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

    private void getAndSetParticipantCount(Integer eventId, EventInfoRequest eventData) {
        long participantCount = participantRepository.countByEventIdAndEventStatus(eventId, Status.ACTIVE);
        eventData.setParticipantCount(participantCount);
    }
}
