package ua.kiev.prog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kiev.prog.service.UserService;
import ua.kiev.prog.service.impl.UserServiceImpl;

@RestController
public class RegistrationController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserServiceImpl userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("signUp")
    public ResponseEntity<?> registration (
            @RequestParam String login,
            @RequestParam String password){
        String hashPassword = passwordEncoder.encode(password);
        userService.createUser(login,hashPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
