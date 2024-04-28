package ee.valiit.playpalback.domain.event.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.id = :eventId and e.status <> :eventStatus")
    Event getEventBy( Integer eventId,  String eventStatus);

    @Query("SELECT e FROM Event e " +
            "JOIN e.location loc " +
            "JOIN loc.city c " +
            "JOIN c.county co " +
            "WHERE (:status IS NULL OR e.status = :status) " +
            "AND (:statusCondition IS NULL OR (:statusCondition = 'is' AND e.status = :status) " +
            "      OR (:statusCondition = 'isnot' AND e.status <> :status)) " +
            "AND (:isParticipant IS NULL OR (:isParticipant = false OR :userId IN (SELECT p.user.id FROM Participant p WHERE p.event.id = e.id))) " + // Check participant
            "AND (:isHost IS NULL OR (:isHost = false OR e.user.id = :userId)) " + // Check host
            "AND (:minPlayers IS NULL OR e.minPlayers >= :minPlayers) " + // Min players
            "AND (:maxPlayers IS NULL OR e.maxPlayers <= :maxPlayers) " + // Max players
            "AND (:minAge IS NULL OR e.minAge >= :minAge) " + // Min age
            "AND (:maxAge IS NULL OR e.maxAge <= :maxAge) " + // Max age
            "AND (:minFee IS NULL OR e.fee >= :minFee) " + // Min fee
            "AND (:maxFee IS NULL OR e.fee <= :maxFee) " + // Max fee
            "AND (SELECT COUNT(p) FROM Participant p WHERE p.event.id = e.id) " +
            "    BETWEEN COALESCE(:minJoinedPlayers, NULL) AND COALESCE(:maxJoinedPlayers, NULL) " + // Joined participants count
            "AND (:countryId = 0 OR co.country.id = :countryId) " + // Country ID
            "AND (:countyId = 0 OR co.id = :countyId) " + // County ID
            "AND (:cityId = 0 OR c.id = :cityId) " + // City ID
            "AND (:skillId = 0 OR e.skill.id = :skillId) " + // Skill ID
            "ORDER BY " +
            "CASE " +
            "   WHEN :sortParameter = 'startDate' THEN e.startDate " +
            "   WHEN :sortParameter = 'endDate' THEN e.endDate " +
            "   WHEN :sortParameter = 'fee' THEN e.fee " +
            "   WHEN :sortParameter = 'joinedPlayers' THEN (SELECT COUNT(p) FROM Participant p WHERE p.event.id = e.id) " +
            "   ELSE e.startDate " +  // Default sorting parameter
            "END " +
            "COALESCE(:sortDirection, 'ASC')")
        // Sorting direction with default ASC
    List<Event> findEventsByFilteringAndSortingParams(Event eventsRequest);


}