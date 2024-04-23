package ee.valiit.playpalback.domain.participant.participant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Participant}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto implements Serializable {
    private Integer eventId;
    private long participantCount;

}