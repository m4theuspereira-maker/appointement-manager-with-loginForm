package com.webencyclop.demo.service;

import java.util.List;

import com.webencyclop.demo.model.Invited;

public interface InvitedService {

    List<Invited> findAll(); 

    Invited findById(long id); 

    Invited save(Invited invited); 

    void delete(long id); 

}