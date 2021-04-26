package com.org.fms.login.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Users")
public class User {

    /**
     * DATA
     */
    private Long _id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userType;
}
