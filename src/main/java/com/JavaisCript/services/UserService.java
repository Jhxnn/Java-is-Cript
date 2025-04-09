package com.JavaisCript.services;

import com.JavaisCript.dtos.UserDto;
import com.JavaisCript.models.User;
import com.JavaisCript.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findById(UUID id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot be found"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User createUser(UserDto userDto){
        var user = new User();
        BeanUtils.copyProperties(userDto, user);
        return userRepository.save(user);
    }

    public User updateUser(UserDto userDto, UUID id){
        var user = findById(id);
        BeanUtils.copyProperties(userDto, user);
        return userRepository.save(user);
    }

    public void deleteUser(UUID id){
        var user = findById(id);
        userRepository.delete(user);
    }
}
