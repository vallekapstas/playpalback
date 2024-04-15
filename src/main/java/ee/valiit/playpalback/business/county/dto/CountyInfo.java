package ee.valiit.playpalback.business.county.dto;

import ee.valiit.playpalback.domain.location.county.County;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link County}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountyInfo implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String name;
}