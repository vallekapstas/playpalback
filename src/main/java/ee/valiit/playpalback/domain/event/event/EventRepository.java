package ee.valiit.playpalback.domain.event.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.id = :eventId and e.status <> :eventStatus")
    Event getEventBy( Integer eventId,  String eventStatus);

    @Query("select e.id from Event e where e.status <> :status and e.startDate >= :startDate order by e.startDate")
    List<Event> findEventsByFilteringAndSortingParams(@Param("status") String status, @Param("startDate") LocalDate startDate);


}