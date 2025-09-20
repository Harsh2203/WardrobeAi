package com.wardrobeai.service;

import com.wardrobeai.model.User;
import com.wardrobeai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public String signUp(User user) {
        if(userRepository.findByEmail(user.getEmail())!=null)
        {
            return "User Already Exist!!";
        }
        userRepository.save(user);
        return "Signed up!!";
    }

    @Override
    public String login(User user)
    {
        User existing=userRepository.findByEmail(user.getEmail());
        if(existing !=null && existing.getPassword().equals(user.getPassword()))
        {
            return "login Successful";
        }
        return "Invalid credentials.";
    }

    @Override
    public String updateUser(long id, User updateUser)
    {
        User existing=userRepository.findById(id).orElse(null);
        if(existing==null)
        {
            return "User not found!!";
        }
        existing.setEmail(updateUser.getEmail());
        existing.setPassword(updateUser.getPassword());
            userRepository.save(existing);
        return "User updated successfully";
    }

    @Override
    public String deleteUser(long id) {
        var existing=userRepository.findById(id).orElse(null);
        if(existing==null)
        {
            return "User not Found!!";
        }
        userRepository.delete(existing);
        return "User deleted!!";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
