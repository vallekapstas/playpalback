package ee.valiit.playpalback.business.county;

import ee.valiit.playpalback.business.county.dto.CountyInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class CountyController {
    private CountyService countyService;
    @GetMapping("/counties/country/{countryId}")
    @Operation(summary = "Returns countyId and countyName",
            description = "Returns a list of all the active counties. Filter by status = 'A' and sort by countyName ASC. ")
    public List<CountyInfo> getCountiesByCountryId(@PathVariable Integer countryId){
        return countyService.getCountiesByCountryId(countryId);
    }
}
