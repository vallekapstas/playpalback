package ee.valiit.playpalback.domain.event.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    @Query("select s from Skill s where s.status = :skillStatus order by s.sort_order")
    List<Skill> findSkillByStatus(String skillStatus);

}