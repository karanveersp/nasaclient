package com.nasaclient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.nasaclient.model.ApiKey;
import com.nasaclient.model.RoverCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @Autowired
    private ApiKey apiKey;

    @GetMapping("/")
    public ModelAndView index() {
        RestTemplate restTemplate = new RestTemplate();
        String yesterday = LocalDate.now().minusDays(1l).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String uri = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=" + yesterday + "&api_key=" + apiKey.getKey();
        String fallbackUri = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2018-11-10&api_key=" + apiKey.getKey();
        RoverCollection rc = restTemplate.getForObject(uri, RoverCollection.class);
        if (rc.getPhotos().length == 0) {
            // if  no photos were uploaded for the rover yesterday. Then display a known date's photos. 
            rc = restTemplate.getForObject(fallbackUri, RoverCollection.class);
        }
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("rc", rc);
        return mv;
    }
}