package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.domain.event.event.EventMapper;
import ee.valiit.playpalback.domain.event.event.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    public static void getEvent(Integer eventId) {
        //    @Mapping(source = "", target = "hostFirstName")
        //    @Mapping(source = "", target = "hostLastName")
        //    @Mapping(source = "", target = "eventImage")

    }
}
