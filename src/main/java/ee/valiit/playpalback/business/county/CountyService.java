package ee.valiit.playpalback.business.county;

import ee.valiit.playpalback.business.city.dto.CityInfo;
import ee.valiit.playpalback.business.county.countyInfo.CountyInfo;
import ee.valiit.playpalback.domain.location.city.CityMapper;
import ee.valiit.playpalback.domain.location.city.CityRepository;
import ee.valiit.playpalback.domain.location.county.County;
import ee.valiit.playpalback.domain.location.county.CountyMapper;
import ee.valiit.playpalback.domain.location.county.CountyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountyService {

    private final CountyRepository countyRepository;
    private final CountyMapper countyMapper;

    public List<CountyInfo> getCountiesByCountryId(Integer countryId) {
        List<County> counties = countyRepository.findCountiesByCountryId(countryId);
        return countyMapper.toCountyInfos(counties);
    }
}
