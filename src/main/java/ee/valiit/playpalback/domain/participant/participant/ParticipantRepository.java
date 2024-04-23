package ee.valiit.playpalback.domain.participant.participant;

import ee.valiit.playpalback.domain.participant.participant.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    @Query("select p from Participant p where p.event.id = :eventId and p.user.id = :userId")
    Participant findParticipantByEventIdAndUserId(Integer eventId, Integer userId);

}