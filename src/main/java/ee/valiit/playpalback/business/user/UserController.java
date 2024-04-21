package ee.valiit.playpalback.business.user;

import ee.valiit.playpalback.business.user.dto.UserProfileInfoExtended;
import ee.valiit.playpalback.business.user.dto.UserProfileInfoRequest;
import ee.valiit.playpalback.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/user/name/{userName}")
    @Operation(summary = "Returns true or false, returns true if username exists.",
            description = "Returns true if username exists, false is returned if username is not found. Request is not case sensitive")
    public boolean getUserNameExists(@PathVariable String userName) {
        return userService.getUserNameExists(userName);
    }

    @PostMapping("/user/register")
    @Operation(summary = "Registering a new user", description = "interestedIn, introduction and userImage are not required")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "This username is already taken", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addUser(@RequestBody UserProfileInfoRequest userProfileInfoRequest) {
        userService.addUser(userProfileInfoRequest);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Retrieves the data of a user by their ID, excluding deactivated users.",
            description = "Returns user’s data(also contains profile data) by id.  Filter by status != ‘D'")
    public UserProfileInfoExtended getUserData(@PathVariable Integer userId) {
        return userService.getUserData(userId);
    }

    @PutMapping("/user/{userId}")
    public void editUserProfile(@PathVariable Integer userId, @RequestBody UserProfileInfoRequest userProfileInfoRequest) {
        userService.editUserProfile(userId, userProfileInfoRequest);

    }

}
