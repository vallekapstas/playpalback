package ee.valiit.playpalback.domain.image.eventimage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EventImageRepository extends JpaRepository<EventImage, Integer> {
    @Query("select e from EventImage e where e.event.id = :id")
    Optional<EventImage> findEventImageByEventId(@Param("id") Integer id);

}