package com.webencyclop.demo.service.serviceImpl;


import java.util.Arrays;
import java.util.HashSet;

import com.webencyclop.demo.model.Role;
import com.webencyclop.demo.model.User;
import com.webencyclop.demo.repository.RoleRepository;
import com.webencyclop.demo.repository.UserRepository;
import com.webencyclop.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository UserRepository;

    @Override
    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus("VERIFIED");
        Role userRole = roleRepository.findByRole("SITE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        UserRepository.save(user);
    }

    @Override
    public boolean isUserAlreadyPresent(User user) {

        /*try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root",
                    "12345");
            PreparedStatement stmt = connection.prepareStatement("select * from auth_user order by email");
            ResultSet r1 = stmt.executeQuery();
            String emailCounter;

            if (r1.next()) {
                emailCounter = r1.getString("email");
                if (emailCounter.equals(user.getEmail())) {
                    return true;
                }
            }

        } catch (Exception e) {
            return false;
        }

        return false;*/
        
        String email = user.getEmail();

        if(UserRepository.existsUserByEmail(email)){
            return true;
        }
        return false;
    } 
}