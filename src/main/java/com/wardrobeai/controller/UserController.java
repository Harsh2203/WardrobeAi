package com.wardrobeai.controller;

import com.wardrobeai.model.User;
import com.wardrobeai.repository.UserRepository;
import com.wardrobeai.service.UserService;
import com.wardrobeai.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody User user){
       return userService.signUp(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/all")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody User user)
    {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id)
    {
        return
    }

}
