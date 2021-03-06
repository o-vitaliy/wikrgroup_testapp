package com.wikrgroup.testapp.models;

import java.io.Serializable;

/**
 * Created by ovitaliy on 19.04.2017.
 */

public class Address  implements Serializable {

    private String street;
    private String suite;
    private String city;
    private String zipcode;

    private Geo geo;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Geo getGeo() {
        return geo;
    }
}
