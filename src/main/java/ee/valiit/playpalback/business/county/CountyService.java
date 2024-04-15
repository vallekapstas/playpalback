package ee.valiit.playpalback.business.county;

import ee.valiit.playpalback.business.county.dto.CountyInfo;
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
