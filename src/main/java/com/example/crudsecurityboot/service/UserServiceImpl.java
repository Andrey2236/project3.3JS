package com.example.crudsecurityboot.service;

import com.example.crudsecurityboot.dao.RoleRepository;
import com.example.crudsecurityboot.dao.UserRepository;
import com.example.crudsecurityboot.model.Role;
import com.example.crudsecurityboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    ConversionService conversionService;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserId(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByName(String userName) {
        return userRepository.getByName(userName);
    }

    @Override
    public Role getByRole(Long id) {
        Optional<Role> optionalUser = roleRepository.findById(id);
        return optionalUser.get();
    }


    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }


    @Override
    public User updateUserAndRoles(User user) {
        return userRepository.save(user);
    }



}
