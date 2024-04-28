package ee.valiit.playpalback.business.event;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.event.dto.EventFilter;
import ee.valiit.playpalback.domain.event.event.Event;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Optional;

public class EventSpecification implements Specification<Event> {

    private final Optional<EventFilter> eventFilter;

    public EventSpecification(Optional<EventFilter> eventFilter) {
        this.eventFilter = eventFilter;
    }

    @Override
    public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        if (eventFilter.isPresent()) {
            EventFilter filter = eventFilter.get();

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
                // Add logic to check participant table
            }

            // isHost and userId
            if (filter.isHost() && filter.getUserid() != null) {
                // Add logic to check if user is host
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
            if (filter.getMinjoined() != null) {
                // Add logic to count joined players
            }
            if (filter.getMaxjoined() != null) {
                // Add logic to count joined players
            }

            // countryId, countyId, cityId, skillId
            // Add logic for location and skill filtering

            // sortParameter and sortDirection
            // Add logic for sorting

        } else {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.notEqual(root.get("status"), Status.DELETED));
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), LocalDate.now()));
        }

        return predicate;
    }
}
