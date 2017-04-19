package com.wikrgroup.testapp.models;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ovitaliy on 19.04.2017.
 */
public class GeoTest {

    private static final String GEO_JSON = " {\n" +
            "        \"lat\": \"-37.3159\",\n" +
            "        \"lng\": \"81.1496\"\n" +
            "  }";


    @Test
    public void testParseGeoFromJson(){
        Geo geo = new Gson().fromJson(GEO_JSON, Geo.class);

        assertNotNull(geo);
        assertEquals(-37.3159, geo.getLat(), 0.1);
        assertEquals(81.1496, geo.getLng(), 0.1);
    }

}