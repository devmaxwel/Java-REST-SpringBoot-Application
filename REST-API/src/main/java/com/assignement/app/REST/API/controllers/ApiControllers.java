package com.assignement.app.REST.API.controllers;

import com.assignement.app.REST.API.Repository.UserRepository;
import com.assignement.app.REST.API.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public  String getPage(){
        return  "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/create")
    public  String SaveUser(@RequestBody User user){
         userRepository.save(user);
        return  "Saved ...";
    }

    @PutMapping(value = "update/{id}")
    public  String UpdateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepository.save(updatedUser);
        return  "Data UpdateD Successfully";
    }
    @DeleteMapping(value ="/delete")
    public String DeleteUser(@PathVariable long id){
        User deleterUser = userRepository.findById(id).get();
        userRepository.delete(deleterUser);
        return  "User Deleted Successfully" +id;
    }
}
