package ee.valiit.playpalback.business.skill;

import ee.valiit.playpalback.business.skill.dto.SkillInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SkillController {
    private SkillService skillService;

    @GetMapping("/skills")
    @Operation(summary = "Returns a list of skills.",
            description = "Returns a list of skills, filtered by status = 'A'. Order by sort_order ASC.")
    public List<SkillInfo> getSkills() {
        return skillService.getSkills();
    }
}
