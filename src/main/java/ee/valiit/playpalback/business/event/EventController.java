package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.business.event.dto.CreateEventInfo;
import ee.valiit.playpalback.business.event.dto.EventInfoRequest;
import ee.valiit.playpalback.business.event.dto.EventList;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @PostMapping("/event")
    @Operation(summary = "Creates an event.",
            description = "Creates an event, including a location and associated games. The event image data is also saved to the database.")
    public void createEvent(@RequestBody CreateEventInfo createEventInfo) {

        eventService.createEvent(createEventInfo);

    }

    @GetMapping("events")
    public List<EventList> getEvents(
            @RequestParam(defaultValue = "A") String status,
            @RequestParam(defaultValue = "is") String stscond,
            @RequestParam(defaultValue = "ASC") String sortdir,
            @RequestParam(defaultValue = "start_date") String sortparam,
            @RequestParam(defaultValue = "") LocalDate datefrom,
            @RequestParam(defaultValue = "") LocalDate dateuntil
    ) {
        return eventService.getEvents(status, stscond, sortdir, sortparam, datefrom, dateuntil);
    }
}
