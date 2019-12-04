/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

/**
 * @Gokul
 *
 */
public class FavoritesDaoCollectionImplTest {

	/**
	 * @param args
	 * @throws FavoritesEmptyException
	 */
	public static void main(String[] args) throws FavoritesEmptyException {

		testAddFavoritesItem();

		testGetAllFavoritesItems();

		testRemoveFavoritesItem();

	}

	public static void testAddFavoritesItem() throws FavoritesEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		favoritesDao.addFavoritesItem((long) 2, (long) 000004);
		favoritesDao.addFavoritesItem((long) 2, (long) 000003);
		List<Movie> movieList = favoritesDao.getAllFavoritesItems((long) 2);
		System.out.println("MenuItem list :" + movieList);

	}

	public static void testGetAllFavoritesItems()
			throws FavoritesEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		List<Movie> movieList = favoritesDao.getAllFavoritesItems((long) 2);
		System.out.println("MenuItem list :" + movieList);

	}

	public static void testRemoveFavoritesItem() throws FavoritesEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;

		try {
			favoritesDao.removeFavoritesItem((long) 2, (long) 4);
			List<Movie> movieList = favoritesDao.getAllFavoritesItems((long) 2);
			System.out.println("MenuItem list after removed:" + movieList);
		} catch (Exception e) {
			throw new FavoritesEmptyException("Favorites is empty");
		}

	}
}
