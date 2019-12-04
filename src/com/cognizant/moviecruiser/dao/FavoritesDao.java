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
public interface FavoritesDao {

	public void addFavoritesItem(Long userId, Long movieId);

	public List<Movie> getAllFavoritesItems(Long userId)
			throws FavoritesEmptyException;

	public void removeFavoritesItem(Long userId, Long menuItemId);
}
