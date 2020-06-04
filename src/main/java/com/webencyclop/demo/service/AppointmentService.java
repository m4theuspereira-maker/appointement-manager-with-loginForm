package com.webencyclop.demo.service;

import java.util.List;

import com.webencyclop.demo.model.Appointment;



public interface AppointmentService {

    List<Appointment> findAll(); 

    Appointment findById(long id); 

    Appointment save(Appointment appointment); 

    void delete(long id); 

    List<Appointment> findByUser_id(int userId);

     
    

}