package ee.valiit.playpalback.business.skill;

import ee.valiit.playpalback.business.skill.dto.SkillInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SkillController {
    private SkillService skillService;

    @GetMapping("/skills")
    public List<SkillInfo> getSkills() {
        return skillService.getSkills();
    }
}
