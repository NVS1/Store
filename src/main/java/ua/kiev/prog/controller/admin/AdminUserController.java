package ua.kiev.prog.controller.admin;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.kiev.prog.model.user.Account;
import ua.kiev.prog.service.UserService;

@RestController
@RequestMapping("/admin/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminUserController {
    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public Page<Account> users (@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        return userService.findAllUsers(pageable);
    }

    @GetMapping("{id}")
    public Account user (@PathVariable("id") Account account){
        return account;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser (
            @PathVariable("id") Account accountDb,
            @RequestBody Account account){

        BeanUtils.copyProperties(account, accountDb, "id");
        userService.updateUser(accountDb);
        return new ResponseEntity<>(accountDb,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser (@PathVariable("id") Account account){
        userService.deleteUser(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
