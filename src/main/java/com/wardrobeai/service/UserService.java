package com.wardrobeai.service;

import com.wardrobeai.model.User;

import java.util.List;


public interface UserService {
    String signUp(User user);
    String login(User user);
    String updateUser(long id,User user);
    String deleteUser(long id);
    List <User> getAllUsers();
}
