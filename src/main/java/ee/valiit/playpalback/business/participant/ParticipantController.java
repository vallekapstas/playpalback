package ee.valiit.playpalback.business.participant;

import ee.valiit.playpalback.business.participant.dto.ParticipantCountInfo;
import ee.valiit.playpalback.business.participant.dto.ParticipantInfo;
import ee.valiit.playpalback.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/participants/count/event/{eventId}")
    @Operation(summary = "Returns a a count of participants for an event.",
            description = "Takes eventId and filters for status = 'A' for the count; " +
                    "if event does not exist, user count of 0 will be returned.")
    public ParticipantCountInfo getParticipantCountByEventId(@PathVariable Integer eventId) {
        return participantService.getParticipantCountByEventId(eventId);

    }

    @GetMapping("/participants/event/{eventId}")
    @Operation(summary = "Get participants by event.",
            description = "Retrieve a list of participants related to a certain event. Optional Filtering by status.")
    public ResponseEntity<List<ParticipantInfo>> getListOfParticipants(@PathVariable Integer eventId, @RequestParam(value = "status", required = false) String status) {
        List<ParticipantInfo> participants = participantService.getListOfParticipants(eventId, status);
        return new ResponseEntity<>(participants, HttpStatus.OK);
    }
}
