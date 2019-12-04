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
			href="ShowFavoritesServlet">Favorites</a> <a class="header-itemright"
			href="ShowMovieListCustomerServlet">Movies</a>
	</header>
	<br>
	<br>
	<section class="body-main">
		<h1>Favorites</h1>
		<h2 style="color: grey">
			No items in favorites. Use 'Add to Favorites' option in <a
				href="ShowMovieListCustomerServlet">Movie List</a>
		</h2>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>