package ee.valiit.playpalback.business.skill;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SkillController {

    @GetMapping("/skills")
    public void skillSortOrder() {


    }
}
