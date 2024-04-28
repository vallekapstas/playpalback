package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.business.event.dto.EventFilter;
import ee.valiit.playpalback.business.event.dto.EventInfo;
import ee.valiit.playpalback.business.event.dto.EventList;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class EventController {

    private EventService eventService;

    @GetMapping("/event/{eventId}")
    @Operation(summary = "Returns details for an event by it's ID.",
            description = "Also returns the eventImage, Host's firstName and lastName from Profile and participantCount from Participants table; " +
                    "does return only events where status is not DELETED")
    public EventInfo getEventData(@PathVariable Integer eventId) {
        return eventService.getEventData(eventId);
    }

    @GetMapping("/events")
    public List<EventList> getEvents(@RequestParam(required = false) Optional<EventFilter> params) {
        return eventService.getEvents(params);
    }
}
