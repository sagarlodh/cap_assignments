package com.org.fms.login.Service;

import com.org.fms.login.Models.UserRequest;

public interface LoginService {
    /**
     * LOGIN USER VALIDATION
     */
    Object validateUser(UserRequest userRequest);
}
