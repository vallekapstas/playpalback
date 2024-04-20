package ee.valiit.playpalback.business.user.dto;

import ee.valiit.playpalback.domain.user.profile.Profile;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Profile}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileInfoExtended implements Serializable {
    private Integer userId;
    private String username;
    private Integer roleId;
    private Integer genderId;
    private String genderName;
    private Integer cityId;
    private String cityName;
    private String countyName;
    private String countryName;
    @NotNull
    @Size(max = 255)
    private String firstName;
    @NotNull
    @Size(max = 255)
    private String lastName;
    @NotNull
    private LocalDate birthDate;
    private String interestedIn;
    private String introduction;
    private String imageData;

}