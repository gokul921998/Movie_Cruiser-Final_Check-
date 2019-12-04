<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html>
<head>
<title>Movie List for Customers</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="header container-fluid">
		<h1 class="header-itemleft" style="padding-left: 50px; float: left">Movie
			Cruiser</h1>
		<img src="image/image1.png"> <a class="header-itemright"
			href="ShowMovieListCustomerServlet">Movies</a>
	</header>
	<br>
	<br>
	<c:if test="${removeFavoritesStatus}">
		<h2 style="text-align: center; color: green">Movie removed from
			favorites successfully</h2>
	</c:if>
	<section class="body-main">
		<h1>Favorites</h1>
		<br> <br>
		<c:set var="count" value="${0}" />
		<table>
			<tr>
				<th style="width: 200px" class="th-text-align-left">Title</th>
				<th class="th-text-align-right">Box Office</th>
				<th>Genre</th>

				<th></th>
			</tr>
			<c:forEach var="movie" items="${favoritesMovieList}">
				<tr>
					<td class="th-text-align-left">${movie.title}</td>
					<td class="th-text-align-right" style="width: 100px"><fmt:setLocale
							value="en_US" /> <fmt:formatNumber type="currency"
							value="${movie.boxOffice}" /></td>
					<td style="width: 80px">"${movie.genre}"</td>
					<c:set var="count" value="${count+1}" />

					<td><a href="RemoveFavoritesServlet?movieId=${movie.id}">Delete</a></td>
				</tr>

			</c:forEach>
			<tr>
				<th class="favorites">No. of favorites: <c:out value="${count}" /></th>
			</tr>
		</table>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>