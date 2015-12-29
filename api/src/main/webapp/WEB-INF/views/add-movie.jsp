<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css" />" media="screen" />
		<title>Add Movie</title>
	</head>
	
	<body>
	
	<!-- Include the Banner -->
	<%@ include file="banner.jsp" %>
	
	<!-- Form for all input Fields -->
	<div class="form-horizontal" role="form">
		<div class="form-group">
			<label class="col-sm-2 control-label" for="movieTitle">Movie Title:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="movieTitle" placeholder="Example: Donnie Darko">
			</div>
			<div class="col-sm-1">
				<button class="form-control btn btn-primary" id="search">Search</button>
			</div>
		</div>
	</div>
	<form class="form-horizontal" role="form" name="add-movie">
		<div class="form-group">
			<label class="col-sm-2 control-label" for="year">Year:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="year" placeholder="Example: 2001">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="rating">Rating:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="rating" placeholder="Example: R">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="released">Released:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="released" placeholder="Example: 30 Jan 2002">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="runtime">Runtime:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="runtime" placeholder="Example: 113 min">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="genre">Genre:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="genre" placeholder="Example: Drama, Mystery, Sci-Fi">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="director">Director:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="director" placeholder="Example: Richard Kelly">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="writer">Writer:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="writer" placeholder="Example: Richard Kelly">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="actors">Actors:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="actors" placeholder="Example: Jake Gyllenhall, Holmes Osborne, Maggie Gyllenhaal, Daveigh Chase">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="plot">Plot:</label>
			<div class="col-sm-3">
				<textarea class="form-control" id="plot" rows="3" placeholder="Example: A troubled teenager is plagued by visions of a large bunny rabbit that manipulates him to commit a series of crimes, after narrowly escaping a bizarre accident."></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="language">Language:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="language" placeholder="Example: English">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="country">Country:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="country" placeholder="Example: USA">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="awards">Awards:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="awards" placeholder="Example: 11 wins & 12 nominations">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="poster">Poster:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="poster" placeholder="Example: http://ia.media-imdb.com/images/M/MV5BMTczMzE4Nzk3N15BMl5BanBnXkFtZTcwNDg5Mjc4NA@@._V1_SX300.jpg">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="metascore">Metascore:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="metascore" placeholder="Example: 71">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="imdbRating">IMDB Rating:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="imdbRating" placeholder="Example: 8.1">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="imdbVotes">IMDB Votes:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="imdbVotes" placeholder="Example: 454,083">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="imdbID">IMDB ID:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="imdbID" placeholder="Example: tt0246578">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="type">Type:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="type" placeholder="Example: movie">
			</div>
		</div>
	</form>
	<div class="form-horizontal" role="form">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-1">
				<button class="form-control btn btn-primary" id="submit">Submit</button>
			</div>
		</div>
	</div>
	
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="<c:url value="/js/bootstrap.js" />"></script>
	<script src="<c:url value="/js/bootstrap-hover-dropdown.js" />"></script>
	
	<script type="text/javascript">
		$('#search').click(function() {
			var movieTitle = encodeURIComponent($('#movieTitle').val());
			var request = $.ajax({
				url: 'details/title/' + movieTitle,
				type: 'GET',
				dataType: 'json',
			});
			request.success(function(movieJson) {
				$('#year').val(movieJson.Year);
				$('#rating').val(movieJson.Rated);
				$('#released').val(movieJson.Released);
				$('#runtime').val(movieJson.Runtime);
				$('#genre').val(movieJson.Genre);
				$('#director').val(movieJson.Director);
				$('#writer').val(movieJson.Writer);
				$('#actors').val(movieJson.Actors);
				$('#plot').val(movieJson.Plot);
				$('#language').val(movieJson.Language);
				$('#country').val(movieJson.Country);
				$('#awards').val(movieJson.Awards);
				$('#poster').val(movieJson.Poster);
				$('#metascore').val(movieJson.Metascore);
				$('#imdbRating').val(movieJson.imdbRating);
				$('#imdbVotes').val(movieJson.imdbVotes);
				$('#imdbID').val(movieJson.imdbID);
				$('#type').val(movieJson.Type);
			});
		});
		$('#submit').click(function() {
			var myObject = new Object();
			myObject.Title = $('#movieTitle').val();
			myObject.Year = $('#year').val();
			myObject.Rating = $('#rating').val();
			myObject.Released = $('#released').val();
			myObject.Runtime = $('#runtime').val();
			myObject.Genre = $('#genre').val();
			myObject.Director = $('#director').val();
			myObject.Writer = $('#writer').val();
			myObject.Actors = $('#actors').val();
			myObject.Plot = $('#plot').val();
			myObject.Langauge = $('#language').val();
			myObject.Country = $('#country').val();
			myObject.Awards = $('#awards').val();
			myObject.Poster = $('#poster').val();
			myObject.Metascore = $('#metascore').val();
			myObject.imdbRating = $('#imdbRating').val();
			myObject.imdbVotes = $('#imdbVotes').val();
			myObject.imdbID = $('#imdbID').val();
			myObject.Type = $('#type').val();
			
			var json = JSON.stringify(myObject);
			var postRequest = $.ajax({
				url: 'create',
				type: 'POST',
				dataType: "text",
				contentType: "application/json",
				data: json
			});
			postRequest.success(function(response) {
				alert(response);
			});
		});
	</script>
	
	</body>
</html>