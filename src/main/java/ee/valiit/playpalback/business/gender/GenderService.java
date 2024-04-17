package ee.valiit.playpalback.business.gender;

import ee.valiit.playpalback.business.gender.dto.GenderInfo;
import ee.valiit.playpalback.domain.user.gender.Gender;
import ee.valiit.playpalback.domain.user.gender.GenderMapper;
import ee.valiit.playpalback.domain.user.gender.GenderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenderService {

    private final GenderMapper genderMapper;
    private final GenderRepository genderRepository;

    public List<GenderInfo> getGenders() {
        List<Gender> genders = genderRepository.findActiveGenders();
        return genderMapper.toGenderInfos(genders);
    }

}
