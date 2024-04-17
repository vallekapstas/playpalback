package ee.valiit.playpalback.business.gender;

import ee.valiit.playpalback.business.gender.dto.GenderInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GenderController {

    private final GenderService genderService;

    @GetMapping("/genders")
    @Operation(summary = "Returns genderId and genderName",
            description = "Returns a list of all the active genders. Filter by status = 'A' and sort by genderName ASC. ")
    public List<GenderInfo> getGenders() {
        return genderService.getGenders();
    }


}
