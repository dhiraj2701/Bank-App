package com.Bank.app.Controller;

import com.Bank.app.Service.IUserService;
import com.Bank.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return iUserService.createUser(user);
    }
}
