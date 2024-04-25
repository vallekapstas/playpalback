package ee.valiit.playpalback.business.participant.dto;

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
public class AddParticipantToEventRequest implements Serializable {
    private Integer eventId;
    private Integer userId;
}