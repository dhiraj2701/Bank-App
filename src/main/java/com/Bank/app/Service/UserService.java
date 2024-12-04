package com.Bank.app.Service;

import com.Bank.app.model.User;
import com.Bank.app.dao.UserRepo;
import com.Bank.app.Entity.TblUser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<?> createUser(User user) {
        TblUser userExistence = userRepo.findByUserName(user.getUserName());
        if (userExistence != null) {
            return new ResponseEntity<>("User Already Exist", HttpStatus.OK);
        }
        if (user.getUserName() == null) {
            return new ResponseEntity<>("adminId can't be null", HttpStatus.OK);
        }
        TblUser tblUser = TblUser.builder()
                .userName(user.getUserName())
                .fullName(user.getFullName())
                .isAdminUser(true)
                .isGroupUser(false)
                .build();
        userRepo.save(tblUser);
        return new ResponseEntity<>(tblUser, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllUser() {
        List<TblUser> listTblUser = userRepo.findAll();
        return new ResponseEntity<>(listTblUser, HttpStatus.OK);
    }
}
