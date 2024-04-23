package ee.valiit.playpalback.business.participant;

import ee.valiit.playpalback.business.participant.dto.ParticipantInfo;
import ee.valiit.playpalback.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Participant Not Found", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ParticipantInfo getParticipantOfEvent(@PathVariable Integer eventId, @PathVariable Integer userId) {
        return participantService.getParticipantOfEvent(eventId, userId);
    }
}
