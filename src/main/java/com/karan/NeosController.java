package com.karan;

import com.karan.model.NeoCollection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class NeosController {

    private final String apiKey = "bTzyD258puKDeYt7DGIipmWYJNh1dmygEJxx9itY";

    @GetMapping("/near-earth-objects-restful")
    public NeoCollection restfulGet() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.nasa.gov/neo/rest/v1/feed?api_key=" + apiKey;
        NeoCollection nc = restTemplate.getForObject(uri, NeoCollection.class);
        return nc;
    }

    @GetMapping("/near-earth-objects")
    public ModelAndView doGet() {
        ModelAndView mv = new ModelAndView("near_earth_objects");
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.nasa.gov/neo/rest/v1/feed?api_key=" + apiKey;
        NeoCollection neos = restTemplate.getForObject(uri, NeoCollection.class);
        mv.addObject("neos", neos);
        return mv;
    }
}