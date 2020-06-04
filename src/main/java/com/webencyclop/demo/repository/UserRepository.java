package com.webencyclop.demo.repository;




import java.util.List;

import com.webencyclop.demo.model.Appointment;
import com.webencyclop.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    boolean existsUserByEmail(String email); 


    User findByEmail(String email);

	User save(List<Appointment> idAppointments);


}