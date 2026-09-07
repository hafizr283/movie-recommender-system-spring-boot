package io.datajek.spring.basics.movie_recommender_system.lesson2;

public class RecommenderImplementation {
    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    public String[] recommendMovies (String movie) {
//        ContentBasedFilter contentBasedFilter = new ContentBasedFilter();
        return filter.getRecommendations(movie);
    }
}
