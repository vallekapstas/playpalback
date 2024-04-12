package ee.valiit.playpalback.business.city;

import ee.valiit.playpalback.business.city.dto.CityInfo;
import ee.valiit.playpalback.domain.location.city.City;
import ee.valiit.playpalback.domain.location.city.CityMapper;
import ee.valiit.playpalback.domain.location.city.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public List<CityInfo> getCitiesByCountyId(Integer countyId) {
        List<City> cities = cityRepository.findCitiesByCountyId(countyId);
        return cityMapper.toCityInfos(cities);
    }
}
