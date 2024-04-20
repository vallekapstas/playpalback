package ee.valiit.playpalback.domain.image.profileimage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, Integer> {
    @Query("select p from ProfileImage p where p.profile.user.id = :userId")
    Optional<ProfileImage> findProfileImageByUserId(Integer userId);

}