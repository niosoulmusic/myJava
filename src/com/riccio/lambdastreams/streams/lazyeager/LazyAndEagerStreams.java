package com.riccio.lambdastreams.streams.lazyeager;

import com.riccio.lambdastreams.domain.Movie;
import com.riccio.lambdastreams.util.MovieUtil;

import java.util.List;
import java.util.stream.Stream;

// Lazy and eager operations
public class LazyAndEagerStreams {
	List<Movie> movies = MovieUtil.createMovies();

	private void testLazy() {
		movies.stream().filter(m -> {
			System.out.println("Inside lazy operation");
			return m.isClassic() ? true : false;
		}).count();
	}

	private void testEager() {
		Stream<Movie> moviesStream = 
			movies.stream()
				.filter(m -> {
			System.out.println("Fitering");
			return m.isClassic() ? true : false;
		}).map(s -> {
			System.out.println("Mapping");
			return s;
		});

		System.out.println("" + moviesStream.count());
	}

	public static void main(String[] args) {
		new LazyAndEagerStreams().testLazy();
		new LazyAndEagerStreams().testEager();
	}

}
