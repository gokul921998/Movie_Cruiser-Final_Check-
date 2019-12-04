/**
 * 
 */
package com.cognizant.moviecruiser.model;

import java.util.List;

/**
 * @Gokul
 *
 */
public class Favorites {
	private List<Movie> movieList;
	private Double total;

	/**
	 * @param movieList
	 * @param total
	 */
	public Favorites(List<Movie> movieList, Double total) {
		super();
		this.movieList = movieList;
		this.total = total;
	}

	/**
	 * 
	 */
	public Favorites() {
		super();
	}

	/**
	 * @return the movieList
	 */
	public List<Movie> getMovieList() {
		return movieList;
	}

	/**
	 * @param movieList
	 *            the movieList to set
	 */
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", total=" + total + "]";
	}

}
