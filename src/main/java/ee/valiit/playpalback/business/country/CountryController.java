package ee.valiit.playpalback.business.country;

import ee.valiit.playpalback.business.country.dto.CountryInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping("/countries")
    @Operation(summary = "Returns countryId and countryName",
            description = "Returns a list of all the active countries. Filter by status = 'A' and sort by countryName ASC. ")
    public List<CountryInfo> getCountries() {
        return countryService.getCountries();
    }
}



