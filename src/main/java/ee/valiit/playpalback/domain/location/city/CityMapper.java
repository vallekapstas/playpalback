package ee.valiit.playpalback.domain.location.city;

import ee.valiit.playpalback.business.city.dto.CityInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {


    @Mapping(source = "id", target = "cityId")
    @Mapping(source = "name", target = "cityName")
    CityInfo toCityInfo(City city);

    List<CityInfo> toCityInfos(List<City> cities);
}