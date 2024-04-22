package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.domain.event.event.Event;
import ee.valiit.playpalback.domain.event.event.EventMapper;
import ee.valiit.playpalback.domain.event.event.EventRepository;
import ee.valiit.playpalback.domain.user.profile.ProfileMapper;
import ee.valiit.playpalback.domain.user.profile.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final ProfileRepository profileRepository;

    private final EventMapper eventMapper;
    private final ProfileMapper profileMapper;

    public static void getEventData(Integer eventId) {

        Event event = eventRepository.getEventBy(eventId);


        //    @Mapping(source = "", target = "hostFirstName")
        //    @Mapping(source = "", target = "hostLastName")
        //    @Mapping(source = "", target = "eventImage")


//        Profile profile = profileRepository.findProfileByUserIdAndStatus(userId, "D");
//        String imageData = getImageData(userId);
//        UserProfileInfoExtended userProfileInfoExtended = profileMapper.toUserProfileInfoExtended(profile);
//        userProfileInfoExtended.setImageData(imageData);
//        return userProfileInfoExtended;

    }
}
