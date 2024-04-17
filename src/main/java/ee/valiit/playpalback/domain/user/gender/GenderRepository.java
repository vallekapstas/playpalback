package ee.valiit.playpalback.domain.user.gender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
    @Query("select g from Gender g where g.status = 'A' order by g.name")
    List<Gender> findActiveGenders();


}