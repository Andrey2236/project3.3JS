package com.example.crudsecurityboot.controller;


import com.example.crudsecurityboot.dao.RoleRepository;
import com.example.crudsecurityboot.model.User;
import com.example.crudsecurityboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    private final UserService userService;

    private final RoleRepository roleRepository;

    @Autowired
    public ApiController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/allusers")
    public List<User> list() {
        return  userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) {
        return userService.getUserId(id);
    }

    @PostMapping("/newUser")
    public User addUserBd(@RequestBody User user) {
        return userService.updateUserAndRoles(user);
    }


//    @PutMapping("/edit/{roles}")
//    public User update(@RequestBody User user,
//                       @PathVariable("roles") String[] roleList) {
//        return userService.updateUserAndRoles(user,roleList);
//    }


    @PutMapping("/edit")
    public User update(@RequestBody User user) {
        return userService.updateUserAndRoles(user);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}




