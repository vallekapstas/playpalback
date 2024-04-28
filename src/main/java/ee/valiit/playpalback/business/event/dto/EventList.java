package ee.valiit.playpalback.business.event.dto;

import ee.valiit.playpalback.domain.event.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Event}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventList implements Serializable {
    private Integer eventId;
}