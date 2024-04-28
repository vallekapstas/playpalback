package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.event.dto.EventFilter;
import ee.valiit.playpalback.domain.event.event.Event;
import ee.valiit.playpalback.domain.participant.participant.Participant;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class EventSpecification implements Specification<Event> {

    private final EventFilter eventFilter;

    public EventSpecification(EventFilter eventFilter) {
        this.eventFilter = eventFilter;
    }

    @Override
    public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        EventFilter filter = eventFilter;

        // Status and StatusCondition
        if (filter.getStatus() != null && filter.getStscond() != null) {
            if ("is".equals(filter.getStscond())) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), filter.getStatus()));
            } else if ("isnot".equals(filter.getStscond())) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.notEqual(root.get("status"), filter.getStatus()));
            }
        } else {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.notEqual(root.get("status"), Status.DELETED));
        }

        // isParticipant and userId
        if (filter.isParticipant() && filter.getUserid() != null) {
            Subquery<Long> participantSubquery = query.subquery(Long.class);
            Root<Participant> participantRoot = participantSubquery.from(Participant.class);
            participantSubquery.select(criteriaBuilder.count(participantRoot));
            participantSubquery.where(
                    criteriaBuilder.and(
                            criteriaBuilder.equal(participantRoot.get("eventId"), root.get("id")),
                            criteriaBuilder.equal(participantRoot.get("userId"), filter.getUserid())
                    )
            );
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(participantSubquery, 1L));
        }

        // isHost and userId
        if (filter.isHost() && filter.getUserid() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("hostId"), filter.getUserid()));
        }

        // minPlayers and maxPlayers
        if (filter.getMinplayers() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("minPlayers"), filter.getMinplayers()));
        }
        if (filter.getMaxplayers() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("maxPlayers"), filter.getMaxplayers()));
        }

        // minAge and maxAge
        if (filter.getMinage() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("minAge"), filter.getMinage()));
        }
        if (filter.getMaxage() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("maxAge"), filter.getMaxage()));
        }

        // minFee and maxFee
        if (filter.getMinfee() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("fee"), filter.getMinfee()));
        }
        if (filter.getMaxfee() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("fee"), filter.getMaxfee()));
        }

        // minJoinedPlayers and maxJoinedPlayers
        if (filter.getMinjoined() != null || filter.getMaxjoined() != null) {
            Subquery<Long> joinedPlayersSubquery = query.subquery(Long.class);
            Root<Participant> joinedPlayersRoot = joinedPlayersSubquery.from(Participant.class);
            joinedPlayersSubquery.select(criteriaBuilder.count(joinedPlayersRoot));
            joinedPlayersSubquery.where(
                    criteriaBuilder.equal(joinedPlayersRoot.get("eventId"), root.get("id"))
            );
            if (filter.getMinjoined() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(
                        joinedPlayersSubquery,
                        criteriaBuilder.literal(Long.valueOf(filter.getMinjoined()))
                ));
            }
            if (filter.getMaxjoined() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(
                        joinedPlayersSubquery,
                        criteriaBuilder.literal(Long.valueOf(filter.getMaxjoined()))
                ));
            }
        }

        // countryId, countyId, cityId, skillId
        if (filter.getCountryid() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("location").get("city").get("county").get("country").get("id"), filter.getCountryid()));
        }
        if (filter.getCountyid() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("location").get("city").get("county").get("id"), filter.getCountyid()));
        }
        if (filter.getCityid() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("location").get("city").get("id"), filter.getCityid()));
        }
        if (filter.getSkillid() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("skillId"), filter.getSkillid()));
        }

        // Sorting logic
        if (filter.getSortparam() != null && filter.getSortdir() != null) {
            String sortParameter = filter.getSortparam();
            String sortDirection = filter.getSortdir();
            switch (sortParameter) {
                case "startDate":
                    if ("asc".equalsIgnoreCase(sortDirection)) {
                        query.orderBy(criteriaBuilder.asc(root.get("startDate")));
                    } else if ("desc".equalsIgnoreCase(sortDirection)) {
                        query.orderBy(criteriaBuilder.desc(root.get("startDate")));
                    }
                    break;
                // Add more cases for other sorting parameters if needed
                default:
                    // Default sorting by startDate ASC
                    query.orderBy(criteriaBuilder.asc(root.get("startDate")));
                    break;
            }
        } else {
            // Default sorting by startDate ASC
            query.orderBy(criteriaBuilder.asc(root.get("startDate")));
        }

        return predicate;
    }
}
