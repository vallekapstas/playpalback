package ee.valiit.playpalback.business.event.dto;

import ee.valiit.playpalback.domain.event.event.Event;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class CreateEventInfo implements Serializable {
    private Integer hostId;
    @NotNull
    @Size(max = 255)
    private String eventName;
    @NotNull
    @Size(max = 255)
    private String venueName;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer minAge;
    private Integer maxAge;
    private BigDecimal fee;
    private Integer skillId;

    private Integer cityId;
    private String postCode;
    private String street;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String eventImage;

}