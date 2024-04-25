package ee.valiit.playpalback.business.event.dto;

import ee.valiit.playpalback.domain.location.location.Location;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link Location}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationInfo implements Serializable {
    private Integer cityId;
    @NotNull
    @Size(max = 10)
    private String postCode;
    @NotNull
    private String street;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String locationStatus;
}