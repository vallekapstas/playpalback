package ee.valiit.playpalback.business.country.dto;

import ee.valiit.playpalback.domain.location.country.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Country}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryInfo implements Serializable {
    private Integer countryId;
    @NotNull
    @Size(max = 255)
    private String countryName;
}