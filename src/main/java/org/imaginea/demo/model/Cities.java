package org.imaginea.demo.model;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Charanjit Singh
 * <p>
 * cities
 */

public class Cities {

    public static List<String> cities = new ArrayList<>();

    public static List<String> getCities() {
        return cities;
    }

    public static void setCities(List<String> cities) {
        Cities.cities = cities;
    }
}
