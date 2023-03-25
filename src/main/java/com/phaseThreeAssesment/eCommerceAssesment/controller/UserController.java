package com.phaseThreeAssesment.eCommerceAssesment.controller;

import com.phaseThreeAssesment.eCommerceAssesment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.phaseThreeAssesment.eCommerceAssesment.model.User;


import java.util.List;

@RestController
@RequestMapping("/phaseThree/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> findAllUsers(){
        return userService.fetchList();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable(value = "id") long id){ return userService.findById(id);}

    @PostMapping("/")
    public User createUser(@RequestBody User user){ return userService.create(user);}

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") long id, @RequestBody User user){
        return userService.update(id,user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(value = "id") long id){
        userService.delete(id);
        return "Deleted";
    }
}
