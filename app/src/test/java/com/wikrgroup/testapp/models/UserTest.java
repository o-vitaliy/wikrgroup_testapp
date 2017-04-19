package com.wikrgroup.testapp.models;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ovitaliy on 19.04.2017.
 */
public class UserTest {

    private static final String USER_JSON = "{\n" +
            "    \"id\": 1,\n" +
            "    \"name\": \"Leanne Graham\",\n" +
            "    \"username\": \"Bret\",\n" +
            "    \"email\": \"Sincere@april.biz\",\n" +
            "    \"address\": {\n" +
            "      \"street\": \"Kulas Light\",\n" +
            "      \"suite\": \"Apt. 556\",\n" +
            "      \"city\": \"Gwenborough\",\n" +
            "      \"zipcode\": \"92998-3874\",\n" +
            "      \"geo\": {\n" +
            "        \"lat\": \"-37.3159\",\n" +
            "        \"lng\": \"81.1496\"\n" +
            "      }\n" +
            "    },\n" +
            "    \"phone\": \"1-770-736-8031 x56442\",\n" +
            "    \"website\": \"hildegard.org\",\n" +
            "    \"company\": {\n" +
            "      \"name\": \"Romaguera-Crona\",\n" +
            "      \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
            "      \"bs\": \"harness real-time e-markets\"\n" +
            "    }\n" +
            "  }";


    @Test
    public void testParseUserJson() {

        User user = new Gson().fromJson(USER_JSON, User.class);

        assertNotNull(user);
        assertEquals(1L, user.getId().longValue());
        assertEquals("Leanne Graham", user.getName());
        assertEquals("Bret", user.getUsername());
        assertEquals("Sincere@april.biz", user.getEmail());
        assertNotNull(user.getAddress());
        assertNotNull("1-770-736-8031 x56442", user.getPhone());
        assertNotNull("hildegard.org", user.getWebsite());
        assertNotNull(user.getCompany());

    }

}