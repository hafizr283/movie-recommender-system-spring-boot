package io.datajek.spring.basics.movie_recommender_system.lesson2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Qualifier("CF")
public class CollaborativeFilter implements Filter{
    public CollaborativeFilter() {
        super();
        System.out.println("Prototype constructor is called");
    }

    @Override

    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story","Collaborative"};
    }
}
