package ee.valiit.playpalback.domain.event.event;

import ee.valiit.playpalback.business.event.dto.EventList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.id = :eventId and e.status <> :eventStatus")
    Event getEventBy(Integer eventId, String eventStatus);

    @Query("SELECT e, " +
            "(SELECT COUNT(p) FROM Participant p WHERE p.event.id = e.id) AS joined_players " +
            "FROM Event e WHERE " +
            "(:stscond = 'is' AND e.status = :status AND e.status <> 'D') OR " +
            "(:stscond = 'isnot' AND e.status <> :status AND e.status <> 'D') " +
            "AND (:datefrom IS NULL OR e.startDate >= :datefrom) " + // Condition for datefrom
            "AND (:dateuntil IS NULL OR e.startDate <= :dateuntil) " + // Condition for dateuntil
            "ORDER BY " +
            "CASE " +
            "WHEN :sortparam = 'start_date' THEN YEAR(e.startDate) * 10000 + MONTH(e.startDate) * 100 + DAY(e.startDate) " +
            "WHEN :sortparam = 'end_date' THEN YEAR(e.endDate) * 10000 + MONTH(e.endDate) * 100 + DAY(e.endDate) " +
            "WHEN :sortparam = 'fee' THEN CASE WHEN e.fee = 0 THEN 1 ELSE e.fee * 100 END " +
            "WHEN :sortparam = 'joined_players' THEN (SELECT COUNT(p) FROM Participant p WHERE p.event.id = e.id) " +
            "ELSE e.id " +
            "END, :sortdir")
    List<Event> findEventsBy(@Param("status") String status,
                             @Param("stscond") String stscond,
                             @Param("sortdir") String sortdir,
                             @Param("sortparam") String sortparam,
                             @Param("datefrom") LocalDate datefrom,
                             @Param("dateuntil") LocalDate dateuntil);



}