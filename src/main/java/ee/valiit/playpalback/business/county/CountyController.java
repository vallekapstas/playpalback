package ee.valiit.playpalback.business.county;

import ee.valiit.playpalback.business.county.countyInfo.CountyInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class CountyController {
    private CountyService countyService;
    @GetMapping("/counties/country/{countryId")
    public List<CountyInfo> getCountiesByCountryId(@PathVariable Integer countryId){
        return countyService.getCountiesByCountryId(countryId);
    }
}
