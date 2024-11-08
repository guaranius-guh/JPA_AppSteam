package com.guaranius.pooii.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranius.pooii.jpa.entity.User;
import com.guaranius.pooii.jpa.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            return userRepository.save(userToUpdate);
        } else {
            throw new RuntimeException("Id " + id + " not found");
        }
    }

    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id " + id + " not found");
        }
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Id " + id + " not found"));
    }
}
