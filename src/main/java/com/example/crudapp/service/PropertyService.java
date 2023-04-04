package com.example.crudapp.service;

import com.example.crudapp.exception.PropertyNotFoundException;
import com.example.crudapp.repo.PropertyRepo;
import com.example.crudapp.model.Property;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PropertyService {
    private final PropertyRepo propertyRepo;

    @Autowired
    public PropertyService(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public Property addProperty(Property property) {
        property.setPropertyCode(UUID.randomUUID().toString());
        return propertyRepo.save(property);
    }

    public List<Property> findAllProperties() {
        return propertyRepo.findAll();
    }

    public Property updateProperty(Property property) {
        Property property1 = propertyRepo.findById(property.getId()).get();
        property1.setPrice(property.getPrice());
        property1.setName(property.getName());
        property1.setLocation(property.getLocation());
        property1.setSize(property.getSize());
        property1.setImageUrl(property.getImageUrl());
        property1.setDescription(property.getDescription());
        property1.setType(property.getType());
        return propertyRepo.save(property1);
    }

    public Property findPropertyById(Long id) {
        return propertyRepo.findPropertyById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property with id " + id + " was not found"));
    }

    public void deleteProperty(Long id) {
        propertyRepo.deletePropertyById(id);
    }

    public void findUserProperties(Long userId){

    }
}
