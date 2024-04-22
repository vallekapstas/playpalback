package ee.valiit.playpalback.domain.image.profileimage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, Integer> {
    @Query("select p from ProfileImage p where p.profile.user.id = :userId")
    Optional<ProfileImage> findProfileImageByUserId(Integer userId);

    @Query("select p from ProfileImage p where p.profile.id = :profileId")
    Optional<ProfileImage> findProfileImageByProfileId(Integer profileId);

    @Transactional
    @Modifying
    @Query("delete from ProfileImage p where p.profile.id = :profileId")
    void deleteByProfileId(Integer profileId);


}