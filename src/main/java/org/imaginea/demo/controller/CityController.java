package org.imaginea.demo.controller;

import org.imaginea.demo.model.HttpResponse;
import org.imaginea.demo.service.AutoCompleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Charanjit Singh
 */

@RestController
public class CityController {

    private static final Logger LOG = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private AutoCompleteService autoCompleteService;

    @RequestMapping("/")
    public String index() {
        LOG.info("Test application");
        return "Greetings from Spring Boot!";
    }


    /**
     * This method fetch the list of cities
     * http://localhost:8080/suggest_cities?start=che&atmost=10
     *
     * @return
     */
    @RequestMapping(value = "/suggest_cities", method = RequestMethod.GET)
    public HttpResponse getSuggestCities(@RequestParam("start") String start,
                                         @RequestParam("atmost") int atmost) {
        LOG.info(CityController.class.getSimpleName() + " received a suggest cities request.");
        LOG.info("The request contains parameter start : " + start + " atmost : " + atmost);
        HttpResponse httpResponse = new HttpResponse();
        if (!start.isEmpty()) {
            List<String> citiesList = autoCompleteService.getCities(start, atmost);

            LOG.info(CityController.class.getSimpleName() + " is responding with: " + citiesList);

            if (!citiesList.isEmpty()) {
                httpResponse.setResponse(citiesList);
                httpResponse.setMessage("Here is the list");
                httpResponse.setStatus(HttpStatus.OK.value());
                return httpResponse;
            } else {
                httpResponse.setMessage("No city starting with string " + start + " found");
                httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
                return httpResponse;
            }
        } else {
            httpResponse.setMessage("Empty String");
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
            return httpResponse;
        }


    }

}
