package ee.valiit.playpalback.business.skill;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.skill.dto.SkillInfo;
import ee.valiit.playpalback.domain.event.skill.Skill;
import ee.valiit.playpalback.domain.event.skill.SkillMapper;
import ee.valiit.playpalback.domain.event.skill.SkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    public List<SkillInfo> getSkills() {
        List<Skill> skillByStatus = skillRepository.findSkillByStatus(Status.ACTIVE);
        return skillMapper.toSkillInfos(skillByStatus);

    }
}
