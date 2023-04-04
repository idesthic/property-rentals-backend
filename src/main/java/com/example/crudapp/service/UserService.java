package com.example.crudapp.service;

import com.example.crudapp.model.Property;
import com.example.crudapp.model.User;
import com.example.crudapp.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<Property> getUserProperties(Long userId){
        User user = userRepo.findById(userId).get();
        return user.getPropertyList();
    }

    public List<Property> getUserFavourites(Long userId){
        User user = userRepo.findById(userId).get();
        return user.getFavouritesList();
    }
}
