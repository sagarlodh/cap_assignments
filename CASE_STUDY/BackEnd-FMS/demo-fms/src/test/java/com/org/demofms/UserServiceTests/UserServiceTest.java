package com.org.demofms.UserServiceTests;

import com.org.demofms.Config.SequenceGeneratorService;
import com.org.demofms.Exceptions.RecordAlreadyPresentException;
import com.org.demofms.Models.User;
import com.org.demofms.Repos.UserRepo;
import com.org.demofms.Services.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @Mock
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    @InjectMocks
    private UserServiceImpl userService;
    private User user1;
    private User user2;
    List<User> userList;
    private Long id = 1L;

    @BeforeEach
    public void setUp(){
        userList = new ArrayList<>();
        user1 = new User("sagar","","email1","","");
        user1 = new User("rahul","","email2","","");
        userList.add(user1);
        userList.add(user2);
    }

    @AfterEach
    public void tearDown(){
        user1 = user2 = null;
        userList = null;
    }

    /****************************************** SERVICE LAYER TESTS *****************************************/

    /**
     * TEST CREATE USER
     */
    @Test
    public void testCreateUser() throws RecordAlreadyPresentException {
/*        when(userRepo.save(any())).thenReturn(user1);
        Optional<User> existingUser = Optional.ofNullable(userRepo.findUserByEmail(user1.getEmail()));
        if(existingUser.isEmpty()){
            user1.setUserId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
            userService.createUser(user1);
        }
        verify(userRepo, times(1)).save(any());*/
        when(userRepo.save(any())).thenReturn(user1);
        user1.setUserId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
        userService.createUser(user1);
        verify(userRepo,times(1)).save(any());
    }

    /**
     * TEST GET ALL USERS
     */
    @Test
    public void testGetAllUsers(){
        userRepo.save(user1);
        when(userRepo.findAll()).thenReturn(userList);
        List<User> userList1 = userService.displayAllUser();
        assertEquals(userList1,userList);
        verify(userRepo,times(1)).save(user1);
        verify(userRepo,times(1)).findAll();
    }

    /**
     * TEST FIND USER BY ID
     */
    @Test
    public void testFindUserById(){
        when(userRepo.findById(id)).thenReturn(Optional.ofNullable(user1));
        assertEquals(Optional.ofNullable(userService.findUserById(id)),userRepo.findById(id));
    }

    /**
     * TEST DELETE USER BY ID
     */
    @Test
    public void testDeleteUserById(){
        when(userRepo.findById(id)).thenReturn(Optional.ofNullable(user1));
        assertEquals(Optional.ofNullable(userService.findUserById(id)),userRepo.findById(id));
        userRepo.delete(user1);
        verify(userRepo, times(1)).delete(user1);
    }

    // test delete User
    @Test
    public void testDeleteUser(){
        User user = new User("","","","","");
        userRepo.delete(user);
        verify(userRepo, times(1)).delete(user);
    }
}
