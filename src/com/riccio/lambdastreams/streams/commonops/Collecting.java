package com.riccio.lambdastreams.streams.commonops;

import com.riccio.lambdastreams.domain.Movie;
import com.riccio.lambdastreams.domain.Trade;
import com.riccio.lambdastreams.util.MovieUtil;
import com.riccio.lambdastreams.util.TradeUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

// Collecting operations
public class Collecting {
	List<Trade> trades = TradeUtil.createTrades();
	
	private void collectIntoAList() {
		List<Trade> tradeCollection = 
				trades.stream().collect(toList());
		
		System.out.println(tradeCollection);
	}
	private void collectIntoASet() {
		Set<Trade> tradeCollection = 
				trades.stream().collect(toSet());
		
		System.out.println(tradeCollection);
	}
	private void collectIntoToAMap() {
		List<Movie> movies = MovieUtil.createMovies();
		
		Map<String, Movie> movieMap = 
				movies.stream().collect(toMap(Movie::getName, movie -> movie));
		System.out.println(movieMap);
	}
	
	public static void main(String[] args) {
		new Collecting().collectIntoAList();
		new Collecting().collectIntoASet();
		new Collecting().collectIntoToAMap();
	}

}
