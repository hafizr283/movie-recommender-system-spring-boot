package io.datajek.spring.basics.movie_recommender_system.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation2 {
    private Filter filter;
    @Autowired
//    @Qualifier("CBF")
    public void setFilter(@Qualifier("CBF") Filter filter) {
        this.filter = filter;
        System.out.println("Setter invoked");
    }

    public String[] recommendMovies (String movie) {
//        ContentBasedFilter contentBasedFilter = new ContentBasedFilter();
        return filter.getRecommendations(movie);
    }
}
