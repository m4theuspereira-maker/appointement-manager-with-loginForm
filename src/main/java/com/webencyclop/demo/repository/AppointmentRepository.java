package com.webencyclop.demo.repository;

import java.util.List;

import com.webencyclop.demo.model.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    List<Appointment> findByUser_id(int userId); 

}