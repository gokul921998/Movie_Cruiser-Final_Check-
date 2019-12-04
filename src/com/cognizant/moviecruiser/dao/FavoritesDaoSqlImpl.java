/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

/**
 * @Gokul
 *
 */
public class FavoritesDaoSqlImpl implements FavoritesDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.moviecruiser.dao.FavoritesDao#addFavoritesItem(java.lang
	 * .Long, java.lang.Long)
	 */
	@Override
	public void addFavoritesItem(Long userId, Long movieId) {
		PreparedStatement preparedStatement;
		Connection connection = ConnectionHandler.getConnection();
		try {
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("insert into favorites values (default, ?, ?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieId);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		PreparedStatement preparedStatement;
		Connection connection = null;
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		List<Movie> movieList = new ArrayList<Movie>();
		double count = 0;

		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {
				Favorites favorites = new Favorites();
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("select movie.mo_id, movie.mo_title, movie.mo_has_teaser, movie.mo_box_office, movie.mo_active, ")
						.append("movie.mo_genre, movie.mo_date_of_launch from movie inner ")
						.append("join favorites on ")
						.append("movie.mo_id = favorites.fa_mo_id ")
						.append("where favorites.fa_us_id = ?;");
				preparedStatement = connection.prepareStatement(sqlBuffer
						.toString());
				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Long movieId = resultSet.getLong(1);
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(4);
					String active = resultSet.getString(5);
					String hasTeaser = resultSet.getString(3);
					String genre = resultSet.getString(6);
					Date dateOfLaunch = resultSet.getDate(7);
					if (hasTeaser != null && hasTeaser.equals("Yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;

					Movie movie = new Movie(movieId, title, boxOffice,
							activeFlag, dateOfLaunch, genre, hasTeaserFlag);
					movieList.add(movie);
					count++;
				}
				favorites.setMovieList(movieList);
				favorites.setTotal(count);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (movieList.size() == 0)
			throw new FavoritesEmptyException("Favorites is empty");
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
		PreparedStatement preparedStatement;
		Connection connection = ConnectionHandler.getConnection();
		try {
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("delete from favorites where fa_us_id = ? and fa_mo_id = ?");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieId);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
