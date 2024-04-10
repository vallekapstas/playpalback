package ee.valiit.playpalback.business.login;

import ee.valiit.playpalback.business.Status;
import ee.valiit.playpalback.business.login.dto.LoginResponse;
import ee.valiit.playpalback.domain.user.user.User;
import ee.valiit.playpalback.domain.user.user.UserMapper;
import ee.valiit.playpalback.domain.user.user.UserRepository;
import ee.valiit.playpalback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password, Status.ACTIVE);
        User user = ValidationService.getValidExistingUser(optionalUser);
        return userMapper.toLoginResponse(user);
    }
}
