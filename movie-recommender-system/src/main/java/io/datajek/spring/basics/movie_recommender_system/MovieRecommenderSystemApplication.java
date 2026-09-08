package io.datajek.spring.basics.movie_recommender_system;

import io.datajek.spring.basics.movie_recommender_system.lesson2.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		ApplicationContext appContext= SpringApplication.run(MovieRecommenderSystemApplication.class, args);
		//lesson 1
//		RecommenderImplementation recommenderImplementation=new RecommenderImplementation();
//		String[] results = recommenderImplementation.recommendMovies("The Matrix");
//		System.out.println(Arrays.toString(results));
		//lesson 2
//		Filter collaborativeFilter = new CollaborativeFilter();
//		RecommenderImplementation implementationOfColaborative = new RecommenderImplementation(collaborativeFilter);
//		System.out.println(Arrays.toString(implementationOfColaborative.recommendMovies("hello")));
//		Filter contentBasedFilter = new ContentBasedFilter();
//		RecommenderImplementation recommenderImplementationContentBased = new RecommenderImplementation(contentBasedFilter);
//		System.out.println(Arrays.toString(recommenderImplementationContentBased.recommendMovies("hello")));
		//lesson 3
//
		// bean scope
		CollaborativeFilter cf1 = appContext.getBean(CollaborativeFilter.class);
		CollaborativeFilter cf2= appContext.getBean(CollaborativeFilter.class);
		CollaborativeFilter cf3 = appContext.getBean(CollaborativeFilter.class);
		ContentBasedFilter cbf1 = appContext.getBean(ContentBasedFilter.class);
		ContentBasedFilter cbf2 = appContext.getBean(ContentBasedFilter.class);
		ContentBasedFilter cbf3 = appContext.getBean(ContentBasedFilter.class);
		//cf is prototype, three new constructor will be called.
		//cbf is singleton (by default) only one constructor will be called
//		System.out.println(cf1);
//		System.out.println(cf2);
//		System.out.println(cf3);
//		// these are prototype bean scope that's why separate object created
//		System.out.println(cf1==cf2?"same":"not same");
		//mixing prototype and default bean scope
		ContentBasedFilter filter = appContext.getBean(ContentBasedFilter.class);
		Movie movie1 = filter.getMovie();
		Movie movie2 = filter.getMovie();
		Movie movie3 = filter.getMovie();
		System.out.println("\nMovie bean with prototype scope");
		System.out.println(movie1);
		System.out.println(movie2);
		System.out.println(movie3);
		System.out.println("\nContentBasedFilter instances created: "+ ContentBasedFilter.getInstances());
		System.out.println("Movie instances created: "+ Movie.getInstances());

	}

}
