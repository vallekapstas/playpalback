package ee.valiit.playpalback.business.user;

import ee.valiit.playpalback.domain.user.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean getUserNameExists(String userName) {
        return userRepository.usernameExists(userName);
    }


}
