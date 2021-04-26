package com.org.demofms.Repos;

import com.org.demofms.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, Long> {
    /**
     * CUSTOM SEARCH CRITERIAS TO BE USED
     */
    User findUserByEmail(String userEmail);
    Iterable<User> findUsersByUserType(String userType);
    Iterable<User> findUsersByFirstName(String userFirstName);
}
