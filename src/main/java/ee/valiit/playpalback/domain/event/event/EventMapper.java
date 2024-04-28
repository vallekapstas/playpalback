package ee.valiit.playpalback.domain.event.event;

import ee.valiit.playpalback.business.event.dto.EventFilter;
import ee.valiit.playpalback.business.event.dto.EventInfoRequest;
import ee.valiit.playpalback.business.event.dto.EventInfosResponse;
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

    List<EventInfosResponse> toEventsInfos(List<Event> events);


//    @Mapping(source = "status", target = "status")
//    @Mapping(source = "stscond", target = "statusCondition")
//    @Mapping(source = "sortdir", target = "sortDirection")
//    @Mapping(source = "sortparam", target = "sortParameter")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "venue", target = "venue")
//    @Mapping(source = "startdate", target = "startDate")
//    @Mapping(source = "enddate", target = "endDate")
//    @Mapping(source = "starttime", target = "startTime")
//    @Mapping(source = "endtime", target = "endTime")
//    @Mapping(source = "participant", target = "isParticipant")
//    @Mapping(source = "host", target = "isHost")
//    @Mapping(source = "userid", target = "user.id")
//    @Mapping(source = "minplayers", target = "minPlayers")
//    @Mapping(source = "maxplayers", target = "maxPlayers")
//    @Mapping(source = "minage", target = "minAge")
//    @Mapping(source = "maxage", target = "maxAge")
//    @Mapping(source = "minfee", target = "minFee")
//    @Mapping(source = "maxfee", target = "maxFee")
//    @Mapping(source = "minjoined", target = "minJoinedPlayers")
//    @Mapping(source = "maxjoined", target = "maxJoinedPlayers")
//    @Mapping(source = "countryid", target = "location.city.county.country.id")
//    @Mapping(source = "countyid", target = "location.city.county.id")
//    @Mapping(source = "cityid", target = "location.city.id")
//    @Mapping(source = "skillid", target = "skill.id")
//    Event toEventFilteringAndSorting(EventFilter params);
}