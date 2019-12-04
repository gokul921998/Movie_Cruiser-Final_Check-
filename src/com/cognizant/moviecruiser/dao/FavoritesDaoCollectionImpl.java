/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

/**
 * @Gokul
 *
 */
public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	/**
	 * @return the userFavorites
	 */
	public static HashMap<Long, Favorites> getUserFavorites() {
		return userFavorites;
	}

	/**
	 * @param userFavorites
	 *            the userFavorites to set
	 */
	public static void setUserFavorites(HashMap<Long, Favorites> userFavorites) {
		FavoritesDaoCollectionImpl.userFavorites = userFavorites;
	}

	public FavoritesDaoCollectionImpl() {
		if (userFavorites == null) {
			userFavorites = new HashMap<Long, Favorites>();
			try {
				List<Movie> movieList = new ArrayList<Movie>();
				Favorites favorites = new Favorites(movieList, 0.0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.moviecruiser.dao.FavoritesDao#addFavoritesItem(java.lang
	 * .Long, java.lang.Long)
	 */
	@Override
	public void addFavoritesItem(Long userId, Long movieId) {

		List<Movie> movieList;
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		Movie movie = movieDao.getMovie(movieId);
		if (userFavorites.containsKey(userId)) {
			Favorites favorites = userFavorites.get(userId);
			movieList = favorites.getMovieList();
			movieList.add(movie);
			favorites.setMovieList(movieList);
			userFavorites.put(userId, favorites);

		} else {
			movieList = new CopyOnWriteArrayList<Movie>();
			movieList.add(movie);

			Favorites favorites = new Favorites(movieList,
					(double) movie.getBoxOffice());
			userFavorites.put(userId, favorites);

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.moviecruiser.dao.FavoritesDao#getAllFavoritesItems(java
	 * .lang.Long)
	 */
	@Override
	public List<Movie> getAllFavoritesItems(Long userId)
			throws FavoritesEmptyException {

		Favorites favorites = userFavorites.get(new Long(userId));
		if (favorites == null) {
			throw new FavoritesEmptyException("Favorites is Empty");
		}
		List<Movie> movieList = favorites.getMovieList();
		if (movieList == null || movieList.size() == 0) {
			throw new FavoritesEmptyException("Favorites is Empty");
		}
		double total = 0.0;
		for (Movie movie : movieList) {
			total = total + movie.getBoxOffice();
		}

		favorites.setTotal(total);
		return movieList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.moviecruiser.dao.FavoritesDao#removeFavoritesItem(java.
	 * lang.Long, java.lang.Long)
	 */
	@Override
	public void removeFavoritesItem(Long userId, Long movieId) {

		if (userFavorites.containsKey(userId)) {
			Favorites favorites = userFavorites.get(userId);
			List<Movie> movieList = favorites.getMovieList();
			for (Movie movie : movieList) {
				if (movie.getId() == movieId) {
					movieList.remove(movie);
				}
			}
			favorites.setMovieList(movieList);
			userFavorites.put(userId, favorites);

		}

	}

}
