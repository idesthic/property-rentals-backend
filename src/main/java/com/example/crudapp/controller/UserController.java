package com.example.crudapp.controller;

import com.example.crudapp.model.Property;
import com.example.crudapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userProperties/{userId}")
    public ResponseEntity<List<Property>> getUserProperties(@PathVariable("userId") Long userId) {
        List<Property> propertyList = userService.getUserProperties(userId);
        return new ResponseEntity<>(propertyList, HttpStatus.OK);
    }

    @GetMapping("/userFavourites/{userId}")
    public ResponseEntity<List<Property>> getUserFavourites(@PathVariable("userId") Long userId) {
        List<Property> favouritesList = userService.getUserFavourites(userId);
        return new ResponseEntity<>(favouritesList, HttpStatus.OK);
    }

  /*  @PutMapping("/userProperties/{userId}")
    public ResponseEntity<List<Property>> putUserProperties(@PathVariable("userId") Long userId) {
        List<Property> favouritesList = userService.getUserFavourites(userId);
        return new ResponseEntity<>(favouritesList, HttpStatus.OK);
    }*/
}