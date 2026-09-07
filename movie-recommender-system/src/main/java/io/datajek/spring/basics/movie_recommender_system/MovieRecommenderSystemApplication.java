package io.datajek.spring.basics.movie_recommender_system;

import io.datajek.spring.basics.movie_recommender_system.lesson2.CollaborativeFilter;
import io.datajek.spring.basics.movie_recommender_system.lesson2.ContentBasedFilter;
import io.datajek.spring.basics.movie_recommender_system.lesson2.Filter;
import io.datajek.spring.basics.movie_recommender_system.lesson2.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommenderSystemApplication.class, args);
		//lesson 1
//		RecommenderImplementation recommenderImplementation=new RecommenderImplementation();
//		String[] results = recommenderImplementation.recommendMovies("The Matrix");
//		System.out.println(Arrays.toString(results));
		//lesson 2
		Filter collaborativeFilter = new CollaborativeFilter();
		RecommenderImplementation implementationOfColaborative = new RecommenderImplementation(collaborativeFilter);
		System.out.println(Arrays.toString(implementationOfColaborative.recommendMovies("hello")));
		Filter contentBasedFilter = new ContentBasedFilter();
		RecommenderImplementation recommenderImplementationContentBased = new RecommenderImplementation(contentBasedFilter);
		System.out.println(Arrays.toString(recommenderImplementationContentBased.recommendMovies("hello")));
	}

}
