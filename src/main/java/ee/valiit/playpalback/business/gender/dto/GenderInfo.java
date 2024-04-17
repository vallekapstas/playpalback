package ee.valiit.playpalback.business.gender.dto;

import ee.valiit.playpalback.domain.user.gender.Gender;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Gender}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenderInfo implements Serializable {
    private Integer genderId;
    @NotNull
    @Size(max = 255)
    private String genderName;
}