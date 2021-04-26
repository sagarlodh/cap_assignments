package com.org.fms.login.Repos;

import com.org.fms.login.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends MongoRepository<User, Long> {
    /**
     * CUSTOM METHOD FOR FETCHING LOGIN INFO
     */
    User findUserByEmail(String userEmail);
}
