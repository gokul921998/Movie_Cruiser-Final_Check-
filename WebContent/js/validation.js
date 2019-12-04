function validateMovieForm() {
	var title = document.forms["editMovieForm"]["movieName"].value;
	var boxOffice = document.forms["editMovieForm"]["boxoffice"].value;
	var dateOfLaunch = document.forms["editMovieForm"]["date"].value;
	var genre = document.forms["editMovieForm"]["movieType"].value;
	if (title == "") {
		alert("Title is required");
		return false;
	} else if (title.length < 2 || title.length > 100) {
		alert("Title should have 2 to 100 characters");
		return false;
	}
	if (boxOffice == "") {
		alert("Box Office is required");
		return false;
	} else if (isNaN(boxOffice)) {
		alert("Box Office has to be a number");
		return false;
	}
	if (dateOfLaunch == "") {
		alert("Date of Launch is required");
		return false;
	}
	if (genre == "") {
		alert("Select one genre");
		return false;
	}
}