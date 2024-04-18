package ee.valiit.playpalback.infrastructure.validation;

import ee.valiit.playpalback.domain.user.user.User;
import ee.valiit.playpalback.infrastructure.exception.ForbiddenException;

import java.util.Optional;

import static ee.valiit.playpalback.infrastructure.error.Error.*;

public class ValidationService {
    public static User getValidExistingUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }
    public static void validateUserNameIsAvailable(boolean usernameExists) {
        if (usernameExists) {
            throw new ForbiddenException(USER_EXISTS.getMessage(), USER_EXISTS.getErrorCode());
        }

    }
}
