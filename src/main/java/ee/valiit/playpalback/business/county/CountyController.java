package ee.valiit.playpalback.business.county;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CountyController {
    private final  CountyService countyService;
    public void getCounties() {
 return;
    }
}
