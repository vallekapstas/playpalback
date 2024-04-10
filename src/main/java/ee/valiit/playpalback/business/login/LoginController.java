package ee.valiit.playpalback.business.login;

import ee.valiit.playpalback.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Login. Returns userId and roleName.",
            description = "Returns userId and roleName if provided username and password are matched with the DB." +
                    "If match not found, errorCode 403001 will be thrown.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Wrong username or password",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void login(@RequestParam String username, @RequestParam String password) {
        loginService.login(username, password);
    }

}
