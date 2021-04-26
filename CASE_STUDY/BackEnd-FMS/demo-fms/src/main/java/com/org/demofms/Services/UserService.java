package com.org.demofms.Services;

import com.org.demofms.Models.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * BUSINESS METHODS
     */
    String createUser(User newUser);
    String updateUser(Long userId);
    String deleteUser(Long userId);
    List<User> displayAllUser();
    User findUserById(Long userId);
    Iterable<User> getUsersByUserType(String userType);
    Iterable<User> getUsersByFirstName(String firstName);

    // find by Email for LOGIN-SERVICE
        //Optional<User> getUserByEmail(String userEmail);
}
