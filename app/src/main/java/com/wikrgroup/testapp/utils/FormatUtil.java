package com.wikrgroup.testapp.utils;

import com.wikrgroup.testapp.models.Address;
import com.wikrgroup.testapp.models.Company;
import com.wikrgroup.testapp.models.Geo;

import java.util.Locale;

/**
 * Created by ovitaliy on 19.04.2017.
 */

public class FormatUtil {

    public static String formatGeo(Geo geo) {
        return String.format(Locale.getDefault(), "%.6f:%.6f", geo.getLat(), geo.getLng());
    }

    public static String formatAddress(Address address) {
        return String.format(
                Locale.getDefault(),
                "%s, %s, %s, %s\n%s",
                address.getZipcode(), address.getCity(), address.getStreet(), address.getSuite(), formatGeo(address.getGeo())
        );
    }

    public static String formatCompany(Company company) {
        return String.format(
                Locale.getDefault(),
                "%s, %s, %s",
                company.getName(), company.getBs(), company.getCatchPhrase()
        );
    }

}
