package io.datajek.spring.basics.movie_recommender_system.lesson2;

public class CollaborativeFilter implements Filter{
    @Override
    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story","Collaborative"};
    }
}
