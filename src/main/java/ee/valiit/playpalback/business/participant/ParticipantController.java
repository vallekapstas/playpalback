package ee.valiit.playpalback.business.participant;

import ee.valiit.playpalback.business.participant.dto.ParticipantCountInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ParticipantController {
    private ParticipantService participantService;

    @GetMapping("/participants/count/event/{eventId}")
    public ParticipantCountInfo getParticipantCountByEventId(@PathVariable Integer eventId) {
        return participantService.getParticipantCountByEventId(eventId);

    }
}
