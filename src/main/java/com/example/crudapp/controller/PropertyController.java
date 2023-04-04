package com.example.crudapp.controller;

import com.example.crudapp.model.Property;
import com.example.crudapp.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {
    private final PropertyService propertyService;


    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyService.findAllProperties();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable("id") Long id) {
        Property property = propertyService.findPropertyById(id);
        return new ResponseEntity<>(property, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Property> addProperty(@RequestBody Property property) {
        Property newProperty = propertyService.addProperty(property);
        return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Property> updateProperty(@RequestBody Property property) {
        Property updatedProperty = propertyService.updateProperty(property);
        return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable("id") Long id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
