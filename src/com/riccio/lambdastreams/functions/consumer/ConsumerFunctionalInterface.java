package com.riccio.lambdastreams.functions.consumer;

import com.riccio.lambdastreams.domain.Movie;

import java.util.function.Consumer;

/* Consumer Functional Interface */

public class ConsumerFunctionalInterface {
	// Consumer for a movie print info
	Consumer<Movie> printInfo = m -> System.out.println("Printing out movie info: "+m);

	//Consumer for persisting movie
	Consumer<Movie> persistMovie = m -> persist(m);
	
	// Consumer for movie notification
	Consumer<Movie> notifyMovie = m -> notify(m);
	
	private void testConsumer(Movie movie) {
		printInfo.accept(movie);
		persistMovie.accept(movie);
	}
	
	private void notify(Movie m) {
		System.out.println("Notifying about movie"+m);
	}

	public void testAndThen(Movie movie){
		Consumer<Movie> printAndPersistMovie = persistMovie.andThen(printInfo);
		printAndPersistMovie.accept(movie);
		
		Consumer<Movie> chainedConsumer = notifyMovie.andThen(persistMovie).andThen(printInfo);
		chainedConsumer.accept(movie);
	}

	private void persist(Movie m) {
		System.out.println("Persisting movie"+m);
	}

	public static void main(String[] args) {
		Movie movie = new Movie("Gods Must Be Crazy");
		new ConsumerFunctionalInterface().testConsumer(movie);
		new ConsumerFunctionalInterface().testAndThen(movie);
	}

}
