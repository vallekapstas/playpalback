package ee.valiit.playpalback.business.city.dto;

import ee.valiit.playpalback.domain.location.city.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link City}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityInfo implements Serializable {
    private Integer cityId;
    @NotNull
    @Size(max = 255)
    private String cityName;
}