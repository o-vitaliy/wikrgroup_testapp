package com.wikrgroup.testapp.models;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ovitaliy on 19.04.2017.
 */
public class AddressTest {

    private static final String ADDRESS_JSON = "{\"street\": \"Kulas Light\",\n" +
            "      \"suite\": \"Apt. 556\",\n" +
            "      \"city\": \"Gwenborough\",\n" +
            "      \"zipcode\": \"92998-3874\",\n" +
            "      \"geo\": {\n" +
            "        \"lat\": \"-37.3159\",\n" +
            "        \"lng\": \"81.1496\"\n" +
            "      } }";


    @Test
    public void testParseAdressFromJson() {
        Address address = new Gson().fromJson(ADDRESS_JSON, Address.class);

        assertNotNull(address);
        assertEquals("Kulas Light", address.getStreet());
        assertEquals("Apt. 556", address.getSuite());
        assertEquals("Gwenborough", address.getCity());
        assertEquals("92998-3874", address.getZipcode());
        assertNotNull(address.getGeo());
    }

}