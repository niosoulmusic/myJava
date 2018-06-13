package com.riccio.lambdastreams.streams.workingwithstreams;

import com.riccio.lambdastreams.domain.Movie;
import com.riccio.lambdastreams.util.MovieUtil;

import java.util.List;

//Working with Streams
public class WorkingWithStreams {

	List<Movie> movies = MovieUtil.createMovies();

	private void findMoviesByDirector(String director) {
		movies.stream()
		.filter(m-> m.getDirector().equals("Steven Spielberg")? true:false)
		.map(Movie::getName)
		.distinct()
		.limit(3)
		.forEach(System.out::println);
	}

	public static void main(String[] args) {
		new WorkingWithStreams().findMoviesByDirector("Steven Spielberg");
	}

}
