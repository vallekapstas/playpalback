package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.business.event.dto.EventFilter;
import ee.valiit.playpalback.business.event.dto.EventInfoRequest;
import ee.valiit.playpalback.business.event.dto.EventList;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @GetMapping("/events")
    public List<EventList> getEvents(@RequestParam(required = false, defaultValue = "") String status,
                                     @RequestParam(required = false, defaultValue = "") String stscond,
                                     @RequestParam(required = false, defaultValue = "") String sortdir,
                                     @RequestParam(required = false, defaultValue = "") String sortparam,
                                     @RequestParam(required = false, defaultValue = "") String name,
                                     @RequestParam(required = false, defaultValue = "") String venue,
                                     @RequestParam(required = false) LocalDate startdate,
                                     @RequestParam(required = false) LocalDate enddate,
                                     @RequestParam(required = false) LocalTime starttime,
                                     @RequestParam(required = false) LocalTime endtime,
                                     @RequestParam(required = false, defaultValue = "false") boolean participant,
                                     @RequestParam(required = false, defaultValue = "false") boolean host,
                                     @RequestParam(required = false) Integer userid,
                                     @RequestParam(required = false) Integer minplayers,
                                     @RequestParam(required = false) Integer maxplayers,
                                     @RequestParam(required = false) Integer minage,
                                     @RequestParam(required = false) Integer maxage,
                                     @RequestParam(required = false) Double minfee,
                                     @RequestParam(required = false) Double maxfee,
                                     @RequestParam(required = false) Integer minjoined,
                                     @RequestParam(required = false) Integer maxjoined,
                                     @RequestParam(required = false) Integer countryid,
                                     @RequestParam(required = false) Integer countyid,
                                     @RequestParam(required = false) Integer cityid,
                                     @RequestParam(required = false) Integer skillid
    ) {
        EventFilter params = new EventFilter();
        params.setStatus(status);
        params.setStscond(stscond);
        params.setSortdir(sortdir);
        params.setSortparam(sortparam);
        params.setName(name);
        params.setVenue(venue);
        params.setStartdate(startdate);
        params.setEnddate(enddate);
        params.setStarttime(starttime);
        params.setEndtime(endtime);
        params.setParticipant(participant);
        params.setHost(host);
        params.setUserid(userid);
        params.setMinplayers(minplayers);
        params.setMaxplayers(maxplayers);
        params.setMinage(minage);
        params.setMaxage(maxage);
        params.setMinfee(minfee);
        params.setMaxfee(maxfee);
        params.setMinjoined(minjoined);
        params.setMaxjoined(maxjoined);
        params.setCountryid(countryid);
        params.setCountyid(countyid);
        params.setCityid(cityid);
        params.setSkillid(skillid);

        return eventService.getEvents(params);
    }
}
