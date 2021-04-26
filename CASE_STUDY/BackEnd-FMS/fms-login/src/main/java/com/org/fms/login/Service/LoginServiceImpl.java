package com.org.fms.login.Service;

import com.org.fms.login.Models.User;
import com.org.fms.login.Models.UserRequest;
import com.org.fms.login.Repos.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{
    /**
     * LOGIN USER VALIDATION IMPLEMENTATION
     */

    @Autowired
    private LoginRepo loginRepo;

    /**
     * @param userRequest
     * @return Message based on Validation of USER CREDENTIALS
     */
    @Override
    public Object validateUser(UserRequest userRequest) {
        Optional<User> user = Optional.ofNullable(loginRepo.findUserByEmail(userRequest.getEmail()));
        if(user.isPresent()){
            User existingUser = user.get();
            String existingUserPassword = existingUser.getPassword();
            if(existingUserPassword.equals(userRequest.getPassword())){
                return user;
            } else {
                return "Invalid Password!";
            }
        } else {
            return "User Email not found!";
        }
    }

}
