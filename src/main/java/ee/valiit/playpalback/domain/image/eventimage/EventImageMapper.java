package ee.valiit.playpalback.domain.image.eventimage;

import ee.valiit.playpalback.business.event.dto.CreateEventInfo;
import ee.valiit.playpalback.util.StringConverter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventImageMapper {
    @Mapping(source = "eventImage", target = "imageData", qualifiedByName = "toImageData")
    EventImage toEventImage(CreateEventInfo createEventInfo);

    @Named("toImageData")
    static byte[] toImageData(String imageData) {
        return StringConverter.stringToBytes(imageData);
    }
}