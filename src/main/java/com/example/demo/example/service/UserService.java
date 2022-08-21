package com.example.demo.example.service;


import com.example.demo.example.model.User;
import com.example.demo.example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User getById(Long userId){
        return repository.getReferenceById(userId);
    }

    public List<User> getAll(){
        return repository.findAll();
    }

    @Transactional
    public List<User> saveAll(List<User> users){
        return repository.saveAll(users);
    }
}
