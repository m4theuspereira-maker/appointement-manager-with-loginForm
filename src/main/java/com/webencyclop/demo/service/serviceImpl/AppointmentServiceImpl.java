package com.webencyclop.demo.service.serviceImpl;

import java.util.List;

import com.webencyclop.demo.model.Appointment;
import com.webencyclop.demo.repository.AppointmentRepository;
import com.webencyclop.demo.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository repository;

    @Override
    public List<Appointment> findAll() {     
        
        return repository.findAll();
    }

    @Override
    public Appointment findById(long id) {        
        return repository.findById(id).get();
    }

    @Override
    public Appointment save(Appointment appointment) {      
        return repository.save(appointment);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

}