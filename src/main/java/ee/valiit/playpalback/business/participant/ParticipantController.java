package ee.valiit.playpalback.business.participant;

import ee.valiit.playpalback.business.participant.dto.ParticipantInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ParticipantController {
    private ParticipantService participantService;

    @GetMapping("/participant/event/{eventId}/user/{userId}")
    @Operation(summary = "Returns a participant's information by eventId and userId.",
            description = "A participant's information for a specific event.")
    public ParticipantInfo getParticipantOfEvent(@PathVariable Integer eventId, @PathVariable Integer userId) {
        return participantService.getParticipantOfEvent(eventId, userId);
    }
}
