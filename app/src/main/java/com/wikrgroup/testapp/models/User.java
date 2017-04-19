package com.wikrgroup.testapp.models;

/**
 * Created by ovitaliy on 19.04.2017.
 */

public class User {
    private Long id;
    private String username;
    private String name;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }
}
