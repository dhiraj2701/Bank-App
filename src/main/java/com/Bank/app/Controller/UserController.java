package com.Bank.app.Controller;

import com.Bank.app.model.User;
import com.Bank.app.Service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return iUserService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        return iUserService.getAllUser();
    }
}
