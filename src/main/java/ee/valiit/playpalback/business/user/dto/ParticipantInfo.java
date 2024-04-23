package ee.valiit.playpalback.business.user.dto;

import ee.valiit.playpalback.domain.participant.participant.Participant;
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
public class ParticipantInfo implements Serializable {
    private Integer eventId;
    private long participantCount;

}