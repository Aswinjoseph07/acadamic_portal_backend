package ERP.Controller;


import ERP.Entity.User;
import ERP.enums.RegisterRequest;
import ERP.Entity.Student;
import ERP.Service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // REGISTER
    @PostMapping("/register")
    public Student register(@RequestBody RegisterRequest request) {
        return authService.register(request.getUser(), request.getStudent());
    }

    // LOGIN
    @PostMapping("/login")
    public Student login(@RequestParam String username,
                         @RequestParam String password) {
        return authService.login(username, password);
    }
}

