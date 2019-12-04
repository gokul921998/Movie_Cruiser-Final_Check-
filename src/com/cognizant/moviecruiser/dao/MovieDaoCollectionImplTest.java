/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * @Gokul
 *
 */
public class MovieDaoCollectionImplTest {

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

		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		List<Movie> movies = movieDaoCollectionImpl.getMovieListAdmin();
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void testGetMovieListCustomer() {

		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		List<Movie> movies = movieDaoCollectionImpl.getMovieListCustomer();
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
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		movieDao.modifyMovie(movie);
		System.out.println("The modified details are: "
				+ movieDao.getMovie((long) 2));
	}

	public static void testGetMovie() {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter the id: ");
		long id = in.nextLong();
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		Movie movieForFetching = movieDao.getMovie(id);
		System.out.println(movieForFetching);
	}
}
