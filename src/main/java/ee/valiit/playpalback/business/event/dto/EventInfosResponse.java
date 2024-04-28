package ee.valiit.playpalback.business.event.dto;

import ee.valiit.playpalback.domain.event.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link Event}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventInfosResponse implements Serializable {
    private Integer eventId;
}