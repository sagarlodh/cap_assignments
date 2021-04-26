package com.org.demofms.Services;

import com.org.demofms.Config.SequenceGeneratorService;
import com.org.demofms.Exceptions.RecordAlreadyPresentException;
import com.org.demofms.Exceptions.RecordNotFoundException;
import com.org.demofms.Models.User;
import com.org.demofms.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    /**
     * BUSINESS METHOD IMPLEMENTATIONS
     */

    @Autowired
    private UserRepo userRepo;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    /**
     * @param newUser
     * @return CREATES AN USER
     */
    @Override
    public String createUser(User newUser) {
        Optional<User> existingUser = Optional.ofNullable(userRepo.findUserByEmail(newUser.getEmail()));
        if(existingUser.isEmpty()){
            newUser.setUserId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
            userRepo.save(newUser);
            return "You have successfully created an Account with Email-Id: " + newUser.getEmail();
        } else {
            throw new RecordAlreadyPresentException("Please Enter Unique Email!" + " " +
                    "User already exists with Email-ID: " + newUser.getEmail());
        }
    }



    /**
     * @param userId
     * @return UPDATES SPECIFIC USER DETAILS WITH GIVEN USER-ID
     */
    @Override
    public String updateUser(Long userId) {
        return null;
    }



    /**
     * @return A LIST OF ALL USERS
     */
    @Override
    public List<User> displayAllUser() {
        return userRepo.findAll();
    }



    /**
     * @param userId
     * @return USER WITH SPECIFIC USER-ID
     */
    @Override
    public User findUserById(Long userId) {
        return userRepo.findById(userId).orElseThrow(()->new RecordNotFoundException
                ("User does not exist with ID: [" + userId + "] ,Please Enter Valid ID!"));
    }



    /**
     * @param userId
     * @return DELETES USER WITH SPECIFIC USER-ID
     */
    @Override
    public String deleteUser(Long userId) {
        User existingUser = userRepo.findById(userId).orElseThrow(()->
                new RecordNotFoundException("User does not exist with ID: [" + userId + "] ,Please Enter Valid ID!"));
        userRepo.delete(existingUser);
        return "User deleted with Id: " + userId;

    }



    /****************************** CUSTOM CRITERIA FROM REPO IMPLEMENTED *****************************/

    /**
     * @param firstName
     * @return USER / LIST OF USERS WITH SPECIFIC FIRST-NAME
     */
    @Override
    public Iterable<User> getUsersByFirstName(String firstName) {
        return userRepo.findUsersByFirstName(firstName);
    }

    /**
     * @param userType
     * @return A LIST OF USERS WITH SPECIFIC USER-TYPE
     */
    @Override
    public Iterable<User> getUsersByUserType(String userType) {
        return userRepo.findUsersByUserType(userType);
    }


    /******* not used FIND BY EMAIL ********/
    /*@Override
    public Optional<User> getUserByEmail(String userEmail){
        Optional<User> userIfPresent = Optional.ofNullable(userRepo.findUserByEmail(userEmail));
        if(userIfPresent.isPresent()){
            return userIfPresent;
        } else {
            return Optional.of(new User(null, null, null, null, null));
        }
    }*/
}
