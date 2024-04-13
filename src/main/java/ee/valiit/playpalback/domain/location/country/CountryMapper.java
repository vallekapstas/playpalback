package ee.valiit.playpalback.domain.location.country;

import ee.valiit.playpalback.business.country.dto.CountryInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {

    @Mapping(source = "name", target = "countryName")
    @Mapping(source = "id", target = "countryId")
    CountryInfo toCountryInfo(Country country);
    List<CountryInfo> toCountryInfos(List<Country> countries);
}