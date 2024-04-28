package ee.valiit.playpalback.domain.event.event;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.event.dto.CreateEventInfo;
import ee.valiit.playpalback.business.event.dto.EventInfoRequest;
import ee.valiit.playpalback.business.event.dto.EventList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {

    @Mapping(source = "id", target = "eventId")
    @Mapping(source = "user.id", target = "hostId")
    @Mapping(source = "name", target = "eventName")
    @Mapping(source = "venue", target = "venueName")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "endTime", target = "endTime")
    @Mapping(source = "minPlayers", target = "minPlayers")
    @Mapping(source = "maxPlayers", target = "maxPlayers")
    @Mapping(source = "minAge", target = "minAge")
    @Mapping(source = "maxAge", target = "maxAge")
    @Mapping(source = "fee", target = "fee")
    @Mapping(source = "skill.id", target = "skillId")
    @Mapping(source = "skill.name", target = "skillName")
    @Mapping(source = "location.id", target = "locationId")
    @Mapping(source = "location.city.name", target = "cityName")
    @Mapping(source = "location.city.county.name", target = "countyName")
    @Mapping(source = "location.city.county.country.name", target = "countryName")
    @Mapping(source = "status", target = "eventStatus")
    @Mapping(source = "eventDescription", target = "eventDescription")
    EventInfoRequest toEventInfo(Event event);


    @Mapping(source = "eventName", target = "name")
    @Mapping(source = "venueName", target = "venue")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "endTime", target = "endTime")
    @Mapping(source = "minPlayers", target = "minPlayers")
    @Mapping(source = "maxPlayers", target = "maxPlayers")
    @Mapping(source = "minAge", target = "minAge")
    @Mapping(source = "maxAge", target = "maxAge")
    @Mapping(source = "fee", target = "fee")
    @Mapping(constant = Status.ACTIVE, target = "status")
    @Mapping(source = "eventDescription", target = "eventDescription")
    Event toEvent(CreateEventInfo createEventInfo);

    @Mapping(source = "id", target = "eventId")
    EventList toEventList (Event event);

    List<EventList> toEventsList (List<Event> events);
}