package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.business.event.dto.EventInfoRequest;
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
            description = "Also returns the eventImage, Host's firstName and lastName from Profile and participantCount from Participants table; " +
                    "does return only events where status is not DELETED")
    public EventInfoRequest getEventData(@PathVariable Integer eventId) {
        return eventService.getEventData(eventId);
    }
}
