package com.riccio.lambdastreams.streams.commonops;

import com.riccio.lambdastreams.domain.Actor;
import com.riccio.lambdastreams.domain.Movie;
import com.riccio.lambdastreams.util.MovieUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// FlatMap functionality
public class FlatMap {
	List<Movie> movies = MovieUtil.createMoviesAndActors();
	String[] fruits = new String[]{"apples","oranges"};
	String[] veggies = new String[]{"beans","peas"};
	
	private void flatMapMovies(){
		Stream<Actor> actorsStream = 
				movies.stream().flatMap(m -> m.getActors().stream());
		
		actorsStream.forEach(System.out::println);
	}
	
	private void flatMapVeggies() {
		Stream<List<String>> fruitsAndVeggies = 
				Stream.of(Arrays.asList(fruits), Arrays.asList(veggies));
		fruitsAndVeggies.flatMap(s -> s.stream())
		.forEach(System.out::println);
		
	}
	
	public static void main(String[] args) {
		new FlatMap().flatMapVeggies();
		new FlatMap().flatMapMovies();
		
	}

}
