package com.webencyclop.demo.repository;

import com.webencyclop.demo.model.Appointment;
import com.webencyclop.demo.model.Invited;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitedRepository extends JpaRepository<Invited, Long> {

    Iterable<Invited> findByAppointment(Appointment appointment); 
    
}