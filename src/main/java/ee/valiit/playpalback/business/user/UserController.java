package ee.valiit.playpalback.business.user;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{userName}")
    @Operation(summary = "Returns true or false, returns true if username exists.",
            description = "Returns true if username exists, false is returned if username is not found. Request is not case sensitive")
    public boolean getUserNameExists(@PathVariable String userName) {
        return userService.getUserNameExists(userName);
    }

}
