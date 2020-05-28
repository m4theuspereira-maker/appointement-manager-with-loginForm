package com.webencyclop.demo.repository;



import com.webencyclop.demo.model.Appointment;
import com.webencyclop.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query(value = "SELECT * FROM USER WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
    Appointment findByUserId(Appointment userId);


}