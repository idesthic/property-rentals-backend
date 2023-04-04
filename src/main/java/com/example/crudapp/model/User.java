package com.example.crudapp.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String password;

    @OneToMany
    private List<Property> propertyList;

    @ManyToMany
    private List<Property> favouritesList;

    public User() {}

    public User(String firstName, String lastName, String email, String address, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    public List<Property> getFavouritesList() {
        return favouritesList;
    }

    public void setFavouritesList(List<Property> favouritesList) {
        this.favouritesList = favouritesList;
    }
}
