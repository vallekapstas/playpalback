package ee.valiit.playpalback.business.skill.dto;

import ee.valiit.playpalback.domain.event.skill.Skill;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Skill}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillInfo implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String name;
}