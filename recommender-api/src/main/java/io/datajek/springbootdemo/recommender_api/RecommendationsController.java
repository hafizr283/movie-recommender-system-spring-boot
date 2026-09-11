package io.datajek.springbootdemo.recommender_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationsController {
    @GetMapping("movies")
    public Movie getMovie(){
        return new Movie(3.4,"Hamim is not nolhiuu gui f a gay h",1);
    }


}
