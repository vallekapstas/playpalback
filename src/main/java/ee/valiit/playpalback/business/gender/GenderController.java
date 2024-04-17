package ee.valiit.playpalback.business.gender;

import ee.valiit.playpalback.business.gender.dto.GenderInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GenderController {

    private final GenderService genderService;

    @GetMapping("/genders")

    public List<GenderInfo> getGenders() {
        return genderService.getGenders();
    }


}
