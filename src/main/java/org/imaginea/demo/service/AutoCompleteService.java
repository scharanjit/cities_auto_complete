package org.imaginea.demo.service;


import org.imaginea.demo.exceptions.NoCityFoundException;
import org.imaginea.demo.model.Cities;
import org.imaginea.demo.utils.StringsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * @author Charanjit Singh
 */

@Service
public class AutoCompleteService {

    private static final Logger LOG = LoggerFactory.getLogger(AutoCompleteService.class);


    /**
     * @param start
     * @return
     */
    public List<String> getCitiesList(String start) {

        LOG.info(" Inside getCitiesList() " + AutoCompleteService.class.getName());
        List<String> citiesList = null;
        try {
            Predicate<String> startsWith = (v) -> v.startsWith(start);
            citiesList = Cities.cities.stream()
                    .filter(startsWith).collect(Collectors.toList());

            if (!citiesList.isEmpty())
                return citiesList;
            else
                throw new NoCityFoundException("No City Found");

        } catch (NoCityFoundException e) {
            LOG.error("No City Found " + AutoCompleteService.class.getSimpleName() + " " + e.toString());
        }

        return citiesList;
    }


    /**
     * @param citiesList
     * @return
     */
    public List<String> limitCitiesList(List<String> citiesList, int atmost) {
        List<String> finalCitiesList = new ArrayList<String>();
        LOG.info(" Inside limitCitiesList() " + AutoCompleteService.class.getName());


        if (citiesList.size() > atmost) {
            for (int i = 0; i < atmost; i++) {
                finalCitiesList.add(citiesList.get(i));
            }
        } else {
            return citiesList;
        }
        return finalCitiesList;

    }


    /**
     * @param start
     * @param atmost
     * @return
     */
    public List<String> getCities(String start, int atmost) {

        LOG.info(" Inside getCities() " + AutoCompleteService.class.getName());

        String camelCasedString = StringsUtils.stringToCamelCase(start);

        List<String> cityList = getCitiesList(camelCasedString);
        return limitCitiesList(cityList, atmost);
    }
}
