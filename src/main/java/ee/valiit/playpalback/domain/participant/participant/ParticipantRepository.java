package ee.valiit.playpalback.domain.participant.participant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    @Query("select count(p) from Participant p where p.event.id = :eventId and p.event.status = :eventStatus")
    long countByEventIdAndEventStatus(Integer eventId, String status);


}