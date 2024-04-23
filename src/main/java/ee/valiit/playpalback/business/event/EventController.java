package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.business.event.dto.EventInfoRequest;
import ee.valiit.playpalback.business.participant.dto.EventsParticipatedInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EventController {

    private EventService eventService;

    @GetMapping("/event/{eventId}")
    @Operation(summary = "Returns details for an event by it's ID.",
            description = "Also returns the eventImage and Host's firstName and lastName from Profile; does return only events where status is not DELETED")
    public EventInfoRequest getEventData(@PathVariable Integer eventId) {
        return eventService.getEventData(eventId);
    }

    @GetMapping("/user/{userId}/eventcount")
    @Operation(summary = "Returns past event count by userId.",
            description = "Returns userId and eventCount. Only counts events that have end date in the past and where the participant and event status are active.")
    public EventsParticipatedInfo getPastEventCountByUserId(@PathVariable Integer userId) {
        return eventService.getPastEventCountByUserId(userId);

    }
}
