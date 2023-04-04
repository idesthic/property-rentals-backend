package com.example.crudapp.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String location;
    private Long price;
    private Double size;
    private String imageUrl;
    private String type;
    private String propertyCode;
    private String description;

    @ManyToOne
    private User owner;

    public Property() {}

    public Property(String name, String location, Long price, Double size, String imageUrl, String type, String propertyCode, String description) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.size = size;
        this.imageUrl = imageUrl;
        this.type = type;
        this.propertyCode = propertyCode;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) { this.propertyCode = propertyCode; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }

    User getOwner() { return owner; }

    void setOwner(User owner) { this.owner = owner; }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", type='" + type + '\'' +
                ", propertyCode='" + propertyCode + '\'' +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}

