package com.wikrgroup.testapp.models;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ovitaliy on 19.04.2017.
 */
public class CompanyTest {

    private static final String COMPANY_JSON = "{      \"name\": \"Romaguera-Crona\",\n" +
            "      \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
            "      \"bs\": \"harness real-time e-markets\"\n" +
            "    }";


    @Test
    public void testParseGeoFromJson() {
        Company company = new Gson().fromJson(COMPANY_JSON, Company.class);

        assertNotNull(company);
        assertEquals("Romaguera-Crona", company.getName());
        assertEquals("Multi-layered client-server neural-net", company.getCatchPhrase());
        assertEquals("harness real-time e-markets", company.getBs());
    }

}