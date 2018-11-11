package com.karan;

import com.karan.model.Apod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApodController {

    private final String apiKey = "bTzyD258puKDeYt7DGIipmWYJNh1dmygEJxx9itY";

    @GetMapping("/apod")
    public ModelAndView doGet() {
        ModelAndView mv = new ModelAndView("apod");
        
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey;
        Apod apod = restTemplate.getForObject(uri, Apod.class);
        mv.addObject("apod", apod);
        return mv;
    }
}