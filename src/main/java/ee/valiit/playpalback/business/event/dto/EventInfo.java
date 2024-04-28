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
public class EventInfo implements Serializable {
    private Integer eventId;
    private Integer hostId;
    private String hostFirstName;
    private String hostLastName;
    private String eventName;
    private String venueName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer minAge;
    private Integer maxAge;
    private BigDecimal fee;
    private Integer skillId;
    private String skillName;
    private Integer locationId;
    private String cityName;
    private String countyName;
    private String countryName;
    private String eventImage;
    private String eventStatus;
    private long participantCount;
    private String eventDescription;
}