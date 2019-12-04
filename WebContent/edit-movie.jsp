<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!doctype html>
<html>
<head>

<title>Edit Movie Details</title>
<link rel="stylesheet" href="style/style.css">
<script type="text/javascript" src="js/validation.js"></script>
<style>
.body-main th {
	text-align: left;
}

.body-main td {
	text-align: left;
}

.button {
	background-color: #004080;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body>

	<c:set var="genres"
		value="ScienceFiction, Romance, Superhero, Horror, Thriller"
		scope="application" />
	<c:set var="selected" value="${movie.genre}" scope="application" />

	<header class="header container-fluid">
		<h1 style="padding-left: 50px; float: left">Movie Cruiser</h1>
		<img src="image/image1.png"> <a class="header-itemright"
			href="ShowMovieListAdminServlet">Movies</a>
	</header>
	<br>
	<br>
	<section class="body-main">
		<h1 class="header-itemleft">Edit Movie</h1>
		<br> <br>
		<form name="editMovieForm" action="EditMovieServlet" method="post"
			onsubmit="return validateMovieForm()">
			<table style="width: 100%">
				<tr>
					<th colspan="4" style="padding-top: 25px"><label for="mtitle">Title</label></th>
				</tr>
				<tr>
					<td colspan="4"><input type="text" id="mtitle"
						name="movieName" style="width: 86%" value="${movie.title}"></td>
				</tr>
				<tr>
					<th style="padding-top: 25px"><label for="mboxoffice">Gross($)</label></th>
					<th style="padding-top: 25px"><label for="mactive">Active</label></th>
					<th style="padding-top: 25px"><label for="mdate">Date
							of Launch</label></th>
					<th style="padding-top: 25px"><label for="mgenre">Genre</label></th>
				</tr>
				<tr>
					<td><input type="text" name="boxoffice" id="mboxoffice"
						value="${movie.boxOffice}"></td>
					<c:choose>
						<c:when test="${movie.active}">
							<td><input type="radio" name="active" value="yes"
								id="mactive" checked>Yes <input type="radio"
								name="active" value="no" id="mactive"> No</td>
						</c:when>
						<c:otherwise>
							<td><input type="radio" name="active" value="yes"
								id="mactive">Yes <input type="radio" name="active"
								value="no" id="mactive" checked>No</td>
						</c:otherwise>
					</c:choose>
					<td><input type="date" name="date" id="mdate"
						value=<fmt:formatDate pattern="dd/MM/yyyy" value="${movie.dateOfLaunch}"/>></td>
					<td><select name="movieType" id="mgenre">
							<option value="${selected}" selected>${selected}</option>
							<c:forEach items="${genres}" var="genre">
								<c:if test="${genre!= selected}">
									<option value="${genre}">${genre}</option>
								</c:if>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td style="padding-top: 25px"><input type="checkbox"
						name="hasteaser" value="${movie.hasTeaser}"
						<c:if test="${movie.hasTeaser}">checked="checked"</c:if> /> <label>Has
							Teaser</label></td>
				</tr>
				<tr>
					<td><input type="hidden" value="${movie.id}" name="id"></td>
				</tr>
				<tr>
					<td style="padding-top: 25px"><input type="submit"
						class="button" value="Save"></td>
				</tr>
			</table>
		</form>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>