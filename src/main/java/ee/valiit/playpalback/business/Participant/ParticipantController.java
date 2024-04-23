package ee.valiit.playpalback.business.Participant;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ParticipantController {
    @GetMapping("/participants/count/event/{eventId}")
    public void getParticipantCountByEventId(@PathVariable Integer eventId) {
    }
}
