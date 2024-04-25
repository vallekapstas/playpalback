package ee.valiit.playpalback.domain.location.location;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.event.dto.CreateEventInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

//    @Mapping(source = "", target = "city")
    @Mapping(source = "postCode", target = "postCode")
    @Mapping(source = "street", target = "street")
    @Mapping(source = "longitude", target = "longitude")
    @Mapping(source = "latitude", target = "latitude")
    @Mapping(constant = Status.ACTIVE, target = "status")
    Location toLocations(CreateEventInfo createEventInfo);

}