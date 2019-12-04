/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * @Gokul
 *
 */
public class MovieDaoSqlImplTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovie();
		testGetMovie();

	}

	public static void testGetMovieListAdmin() {

		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		List<Movie> movies = movieDaoSqlImpl.getMovieListAdmin();
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void testGetMovieListCustomer() {

		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		List<Movie> movies = movieDaoSqlImpl.getMovieListCustomer();
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void testModifyMovie() {

		Movie movie = null;
		try {
			movie = new Movie(2, "Malificient", 2468975315l, true,
					DateUtil.convertToDate("23/12/2017"), "Thriller", false);
		} catch (ParseException e) {
			System.out.println("Parse Exception: " + e.getMessage());
		}
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		movieDao.modifyMovie(movie);
		System.out.println("The modified details are: "
				+ movieDao.getMovie((long) 2));
	}

	public static void testGetMovie() {
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		Movie movieForFetching = movieDao.getMovie((long)2);
		System.out.println(movieForFetching);
	}
}
