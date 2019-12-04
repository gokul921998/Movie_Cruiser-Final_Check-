package com.cogniant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.FavoritesDaoSqlImpl;
import com.cognizant.moviecruiser.dao.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Movie;

/**
 * Servlet implementation class RemoveFavoritesServlet
 */
@WebServlet("/RemoveFavoritesServlet")
public class RemoveFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveFavoritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long userId = 2;
		long movieId = Long.parseLong(request.getParameter("movieId"));
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		FavoritesDao favoritesDao = favoritesDaoSqlImpl;
		favoritesDao.removeFavoritesItem(userId, movieId);

		List<Movie> favoritesMovieList;
		try {
			favoritesMovieList = favoritesDao.getAllFavoritesItems(userId);
			request.setAttribute("removeFavoritesStatus", true);
			request.setAttribute("favoritesMovieList", favoritesMovieList);
			request.getRequestDispatcher("favorites.jsp").forward(request,
					response);
		} catch (FavoritesEmptyException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("favorites-empty.jsp").forward(
					request, response);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
