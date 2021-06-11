package com.example.crudsecurityboot.service;

import com.example.crudsecurityboot.model.Role;
import com.example.crudsecurityboot.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService   {

     List<User> getAllUsers();

     User saveUser(User user);

     User getUserId(Long id);

     void deleteUser(Long id);

     User getByName(String name);

     Role getByRole(Long id);

     List<Role> getAllRoles();

     User updateUserAndRoles(User user);


}
