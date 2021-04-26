package com.org.bookingservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userType;
}
