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
    @Operation(summary = "Returns true or false, depending on username existence",
            description = "Returns true or false if provided username exists in the database or not")
    public boolean getUserExistence(@PathVariable String userName) {
        return userService.getUserExistence(userName);
    }

}
