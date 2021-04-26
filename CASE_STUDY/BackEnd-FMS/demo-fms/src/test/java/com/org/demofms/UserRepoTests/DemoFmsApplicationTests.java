package com.org.demofms.UserRepoTests;

import com.org.demofms.Config.SequenceGeneratorService;
import com.org.demofms.Models.User;
import com.org.demofms.Repos.UserRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class DemoFmsApplicationTests {

	/*@Test
	void contextLoads() {
	}*/

    @Mock
    private UserRepo userRepo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @BeforeEach
    public void setUp(){
        //user  = new User("","","email","","");
    }
    @AfterEach
    public void tearDown(){
        userRepo.deleteAll();
    }

    /****************************************** REPO LAYER TESTS *****************************************/

    // test USER BY EMAIL
    @Test
    public void testFindUserByEmail(){
        String email = "abc";
        User user1 = new User("sagar","","abc","","");
        when(userRepo.findUserByEmail(email)).thenReturn(user1);
        assertEquals("sagar",userRepo.findUserByEmail(email).getFirstName());
    }

    // test LIST USERS BY USER TYPE
    @Test
    public void testFindUsersByUserType(){
        String userType = "USER";
        List<User> userList= new ArrayList<User>();
        User user1 = new User("sagar","","","","USER");
        userList.add(user1);
        //user1.setUserId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
        userRepo.save(user1);
        when(userRepo.findUsersByUserType(userType)).thenReturn(userList);
        assertEquals(userList,userRepo.findUsersByUserType(userType));
    }

    // test LIST USERS BY FIRST NAME
    @Test
    public void testFindUsersByFirstName(){
        String userFirstName = "Sagar";
        List<User> userList= new ArrayList<User>();
        User user = new User("sagar","","","","USER");
        userList.add(user);
        //user.setUserId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
        userRepo.save(user);
        when(userRepo.findUsersByUserType(userFirstName)).thenReturn(userList);
        assertEquals(userList,userRepo.findUsersByUserType(userFirstName));
    }
}
