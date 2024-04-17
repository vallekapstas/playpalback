package ee.valiit.playpalback.business.user;

import ee.valiit.playpalback.business.user.dto.UserProfileInfoRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/user/{userName}")
    @Operation(summary = "Returns true or false, returns true if username exists.",
            description = "Returns true if username exists, false is returned if username is not found. Request is not case sensitive")
    public boolean getUserNameExists(@PathVariable String userName) {
        return userService.getUserNameExists(userName);
    }

    @PostMapping("/user/register")

    public void addUser(@RequestBody @Valid UserProfileInfoRequest userProfileInfoRequest) {
        userService.addUser(userProfileInfoRequest);
    }

}
