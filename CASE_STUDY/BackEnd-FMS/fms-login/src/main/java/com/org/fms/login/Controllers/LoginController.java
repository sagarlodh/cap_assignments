package com.org.fms.login.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.fms.login.Models.User;
import com.org.fms.login.Models.UserRequest;
import com.org.fms.login.Service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@ComponentScan(basePackages = "com.org.fms")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /*@Autowired
    private RestTemplate restTemplate;*/

    /**
     * VALIDATE USER CREDENTIALS
     */
    @HystrixCommand
    @PostMapping
    public Object validateUser(@RequestBody UserRequest userResponse){
        log.info("Tried Log-In with Credentials as: \n" + userResponse);
        return loginService.validateUser(userResponse);
    }

}
