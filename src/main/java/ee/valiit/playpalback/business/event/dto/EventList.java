package ee.valiit.playpalback.business.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.playpalback.domain.event.event.Event}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventList implements Serializable {
    private Integer eventId;
}