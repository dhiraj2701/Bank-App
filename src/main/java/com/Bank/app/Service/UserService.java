package com.Bank.app.Service;

import com.Bank.app.model.User;
import com.Bank.app.dao.UserRepo;
import com.Bank.app.Entity.TblUser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public ResponseEntity<?> createUser(User user) {
        TblUser tblUser=TblUser.builder()
                .userName(user.getUserName())
                .fullName(user.getFullName())
                .isAdminUser(true)
                .build();
        userRepo.save(tblUser);
        return new ResponseEntity<>(tblUser,HttpStatus.OK);
    }
}
