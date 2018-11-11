package com.nasaclient;

import com.nasaclient.model.ApiKey;
import com.nasaclient.model.NeoCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class NeosController {

    @Autowired
    private ApiKey apiKey;

    @GetMapping("/near-earth-objects-restful")
    public NeoCollection restfulGet() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.nasa.gov/neo/rest/v1/feed?api_key=" + apiKey.getKey();
        NeoCollection nc = restTemplate.getForObject(uri, NeoCollection.class);
        return nc;
    }

    @GetMapping("/near-earth-objects")
    public ModelAndView doGet() {
        ModelAndView mv = new ModelAndView("near_earth_objects");
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.nasa.gov/neo/rest/v1/feed?api_key=" + apiKey.getKey();
        NeoCollection neos = restTemplate.getForObject(uri, NeoCollection.class);
        mv.addObject("neos", neos);
        return mv;
    }
}