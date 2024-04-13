package ee.valiit.playpalback.business.country;

import ee.valiit.playpalback.business.country.dto.CountryInfo;
import ee.valiit.playpalback.domain.location.country.Country;
import ee.valiit.playpalback.domain.location.country.CountryMapper;
import ee.valiit.playpalback.domain.location.country.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryInfo> getCountries() {
        List<Country> countries = countryRepository.findActiveCountries();
        return countryMapper.toCountryInfos(countries);
    }

}

