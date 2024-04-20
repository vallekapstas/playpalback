package ee.valiit.playpalback.domain.user.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {


    @Query("select p from Profile p where p.user.id = :id and p.user.status <> :status")
    Profile findProfileByUserIdAndStatus(Integer id, String status);

}