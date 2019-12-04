<%@	page import="com.cognizant.moviecruiser.model.Movie"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<title>Movie List for Admin</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="header container-fluid">
		<h1 class="header-itemleft" style="padding-left: 50px; float: left">Movie
			Cruiser</h1>
		<img src="image/image1.png"> <a class="header-itemright"
			href="ShowMovieListAdminServlet">Movies</a>
	</header>
	<br>
	<br>
	<br>
	<section class="body-main">
		<h2>Movies</h2>
		<table>
			<tr>
				<th class="th-text-align-left">Title</th>
				<th class="th-text-align-right">Box Office</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach var="movie" items="${movieList}">
				<tr>
					<td class="th-text-align-left">${movie.title}</td>
					<td class="th-text-align-right"><fmt:setLocale value="en_US" />
						<fmt:formatNumber type="currency" value="${movie.boxOffice}" /></td>
					<td>${movie.active ? 'Yes' : 'No'}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${movie.dateOfLaunch}" /></td>
					<td>${movie.genre}</td>
					<td>${movie.hasTeaser ? 'Yes' : 'No'}</td>
					<td><a href="ShowEditMovieServlet?movieId=${movie.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<footer>Copyright©2019</footer>
</body>
</html>