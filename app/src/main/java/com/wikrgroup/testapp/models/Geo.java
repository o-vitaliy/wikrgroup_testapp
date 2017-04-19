package com.wikrgroup.testapp.models;

import java.io.Serializable;

/**
 * Created by ovitaliy on 19.04.2017.
 */

public class Geo implements Serializable {
    private double lat;
    private double lng;

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
