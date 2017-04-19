package com.wikrgroup.testapp.models;

import java.io.Serializable;

/**
 * Created by ovitaliy on 19.04.2017.
 */

public class Company  implements Serializable {
    private String name;
    private String catchPhrase;
    private String bs;

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
