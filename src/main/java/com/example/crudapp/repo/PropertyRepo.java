package com.example.crudapp.repo;

import com.example.crudapp.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropertyRepo extends JpaRepository<Property, Long> {
    void deletePropertyById(Long id);

    Optional<Property> findPropertyById(Long id);

}
