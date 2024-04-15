package ee.valiit.playpalback.domain.location.county;

import ee.valiit.playpalback.business.county.countyInfo.CountyInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountyMapper {


    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "id")
    CountyInfo toCountyInfo(County county);

    List<CountyInfo> toCountyInfos(List<County> counties);


}