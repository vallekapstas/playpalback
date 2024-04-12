package ee.valiit.playpalback.business.city;

import ee.valiit.playpalback.business.city.dto.CityInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @GetMapping("/cities/county/{countyId}")
    @Operation(summary = "Returns cityId and cityName using countyId",
            description = "return a list of all the cities that belong under the provided countyId.")
    public List<CityInfo> getCitiesByCountyId(@PathVariable Integer countyId) {
        return cityService.getCitiesByCountyId(countyId);

    }


}
