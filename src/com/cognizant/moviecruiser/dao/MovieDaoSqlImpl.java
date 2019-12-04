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

import com.cognizant.moviecruiser.model.Movie;

/**
 * @Gokul
 *
 */
public class MovieDaoSqlImpl implements MovieDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.MovieDao#getMovieListAdmin()
	 */
	@Override
	public List<Movie> getMovieListAdmin() {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		List<Movie> movieList = new ArrayList<Movie>();
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movie");
				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					long movieId = resultSet.getLong("mo_id");
					String title = resultSet.getString("mo_title");
					long boxOffice = resultSet.getLong("mo_box_office");
					String active = resultSet.getString("mo_active");
					date_of_launch = resultSet.getDate("mo_date_Of_launch");
					String genre = resultSet.getString("mo_genre");
					String hasTeaser = resultSet.getString("mo_has_teaser");
					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (hasTeaser != null && hasTeaser.equals("Yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					Movie movie = new Movie(movieId, title, boxOffice,
							activeFlag, date_of_launch, genre, hasTeaserFlag);
					movieList.add(movie);
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
		return movieList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.MovieDao#getMovieListCustomer()
	 */
	@Override
	public List<Movie> getMovieListCustomer() {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		List<Movie> movieList = new ArrayList<Movie>();
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from movie where mo_active = 'Yes' and mo_date_of_launch <= now()");
				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					long movieId = resultSet.getLong("mo_id");
					String title = resultSet.getString("mo_title");
					long boxOffice = resultSet.getLong("mo_box_office");
					String active = resultSet.getString("mo_active");
					date_of_launch = resultSet.getDate("mo_date_Of_launch");
					String genre = resultSet.getString("mo_genre");
					String hasTeaser = resultSet.getString("mo_has_teaser");
					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (hasTeaser != null && hasTeaser.equals("Yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					Movie movie = new Movie(movieId, title, boxOffice,
							activeFlag, date_of_launch, genre, hasTeaserFlag);
					movieList.add(movie);
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
		return movieList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.MovieDao#modifyMovie(com.cognizant.
	 * moviecruiser.model.Movie)
	 */
	@Override
	public void modifyMovie(Movie movie) {
		Connection connection = ConnectionHandler.getConnection();
		String query = "update movie set mo_title = ?, mo_box_office = ?, mo_active = ?, mo_date_of_launch = ?, mo_has_teaser = ?, mo_genre = ? where mo_id = ?";
		try {
			if (connection != null) {
				PreparedStatement preparedStatement = connection
						.prepareStatement(query);
				preparedStatement.setString(1, movie.getTitle());
				preparedStatement.setLong(2, movie.getBoxOffice());
				if (movie.isActive())
					preparedStatement.setString(3, "Yes");
				else
					preparedStatement.setString(3, "No");
				preparedStatement.setDate(4, new java.sql.Date(movie
						.getDateOfLaunch().getTime()));
				if (movie.isHasTeaser())
					preparedStatement.setString(5, "Yes");
				else
					preparedStatement.setString(5, "No");
				preparedStatement.setString(6, movie.getGenre());
				preparedStatement.setLong(7, movie.getId());
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
	 * @see com.cognizant.moviecruiser.dao.MovieDao#getMovie(java.lang.Long)
	 */
	@Override
	public Movie getMovie(Long movieId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Movie movie = null;
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from movie where mo_id=?");
				preparedStatement.setLong(1, movieId);

				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					date_of_launch = resultSet.getDate(5);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);
					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (hasTeaser != null && hasTeaser.equals("Yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					movie = new Movie(movieId, title, boxOffice, activeFlag,
							date_of_launch, genre, hasTeaserFlag);
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
		return movie;
	}

}
