package ee.valiit.playpalback.domain.location.county;

import ee.valiit.playpalback.business.county.dto.CountyInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountyMapper {


    @Mapping(source = "name", target = "countyName")
    @Mapping(source = "id", target = "countyId")
    CountyInfo toCountyInfo(County county);

    List<CountyInfo> toCountyInfos(List<County> counties);


}