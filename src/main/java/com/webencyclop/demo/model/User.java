package com.webencyclop.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "auth_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_user_id")
    private int id;

    @NotNull(message = "First name is compulsory")
    @Column(name = "first_name")
    private String name;

    @NotNull(message = "Last name is compulsory")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Email is compulsory")
    @Email(message = "Email is invalid")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Password id compulsory")
    @Length(min=5, message="Password should be at least 5 characters")
    @Column(name = "password")
    private String password;   

    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"),
    inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
    private Set<Role> roles;

    @OneToMany
    private List<Appointment> IdAppointments;

    public List<Appointment> getIdAppointments() {
        return this.IdAppointments;
    }

    public void setIdAppointments(List<Appointment> IdAppointments) {
        this.IdAppointments = IdAppointments;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    } 

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    } 
    
}