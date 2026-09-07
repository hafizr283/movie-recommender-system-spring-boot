package io.datajek.spring.basics.movie_recommender_system.lesson1;

public class RecommenderImplementation {

    public String[] recommendMovies (String movie) {
        ContentBasedFilter contentBasedFilter = new ContentBasedFilter();
        return contentBasedFilter.getRecommendations(movie);
    }
}
