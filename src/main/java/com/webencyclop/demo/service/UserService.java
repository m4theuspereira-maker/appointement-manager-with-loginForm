package com.webencyclop.demo.service;

import com.webencyclop.demo.model.User;


public interface UserService {

    void saveUser(User user);

    boolean isUserAlreadyPresent(User user); 
    
}