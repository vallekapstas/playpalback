package ee.valiit.playpalback.domain.event.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.id = :eventId and e.status <> :eventStatus")
    Event getEventBy( Integer eventId,  String eventStatus);



}