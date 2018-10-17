package ua.kiev.prog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.kiev.prog.model.user.Account;
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
    @PostMapping("/registration")
    public ResponseEntity<?> registration (@RequestBody Account account){
        String hashPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(hashPassword);
        if (userService.createUser(account)){
            return new ResponseEntity<>(account, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
