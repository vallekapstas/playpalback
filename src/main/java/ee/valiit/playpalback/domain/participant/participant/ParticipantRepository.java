package ee.valiit.playpalback.domain.participant.participant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    @Query("select p from Participant p where p.event.id = :eventId and p.user.id = :userId")
    Participant findParticipantByEventIdAndUserId(Integer eventId, Integer userId);

    @Query("select count(p) from Participant p where p.event.id = :eventId and p.event.status = :eventStatus")
    long countByEventIdAndEventStatus(Integer eventId, String eventStatus);

    @Query("select count(p) from Participant p JOIN p.event e where p.user.id = :userId and p.event.status=:eventStatus and p.status=:participantStatus and e.endDate < CURRENT TIMESTAMP ")
    long countParticipantsForPastEvents( Integer userId, String eventStatus, String participantStatus);

}