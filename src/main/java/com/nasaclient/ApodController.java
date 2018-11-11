package com.nasaclient;

import com.nasaclient.model.ApiKey;
import com.nasaclient.model.Apod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApodController {

    @Autowired
    private ApiKey apiKey;

    @GetMapping("/apod")
    public ModelAndView doGet() {
        ModelAndView mv = new ModelAndView("apod");
        
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey.getKey();
        Apod apod = restTemplate.getForObject(uri, Apod.class);
        mv.addObject("apod", apod);
        return mv;
    }
}