package com.Bank.app.Service;

import com.Bank.app.model.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<?> createUser(User user);
}
