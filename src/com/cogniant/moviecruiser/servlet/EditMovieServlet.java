package com.cogniant.moviecruiser.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruiser.model.Movie;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovieServlet")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		String title = request.getParameter("movieName");
		String id = request.getParameter("id");
		String boxOffice = request.getParameter("boxoffice");
		String active = request.getParameter("active");
		String date = request.getParameter("date");
		String movieType = request.getParameter("movieType");
		boolean hasTeaser = request.getParameter("hasteaser") != null;
		Movie movie = new Movie();
		boolean activeFlag;
		if (active.equals("yes"))
			activeFlag = true;
		else
			activeFlag = false;
		movie.setActive(activeFlag);
		movie.setBoxOffice(Long.parseLong(boxOffice));
		movie.setGenre(movieType);
		movie.setHasTeaser(hasTeaser);
		movie.setId(Long.parseLong(id));
		movie.setTitle(title);
		Date dateOfLaunch;
		try {
			dateOfLaunch = sdf.parse(date);
			movie.setDateOfLaunch(dateOfLaunch);
			movieDao.modifyMovie(movie);
			response.sendRedirect("edit-movie-status.jsp");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
