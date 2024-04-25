package ee.valiit.playpalback.domain.event.event;

import ee.valiit.playpalback.domain.game.eventgame.EventGame;
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
    private Integer userId;
    @NotNull
    @Size(max = 255)
    private String eventName;
    @NotNull
    @Size(max = 255)
    private String eventVenue;
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

    private Integer locationCityId;
    private String locationPostCode;
    private String locationStreet;
    private BigDecimal locationLongitude;
    private BigDecimal locationLatitude;

    private EventGame[] eventGames;
    private String eventImage;

}