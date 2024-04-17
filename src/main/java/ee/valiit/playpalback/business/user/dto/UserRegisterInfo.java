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
public class UserRegisterInfo implements Serializable {
    private String userUsername;
    private String userPassword;
    private String userStatus;
    private Integer genderId;
    private Integer cityId;
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
}