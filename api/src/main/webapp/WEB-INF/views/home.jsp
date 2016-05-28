<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css" />" media="screen" />
	<title>Movie</title>

	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container" id="mainContent">
	<!-- ko foreach: genres -->
	<div class="row">
		<h3 data-bind="text: name"></h3>
		<div class="row">
			<!-- ko foreach: movies -->
			<div class="col-md-2">
				<a href="#" class="thumbnail">
					<img data-bind="attr: {src: poster}">
				</a>
			</div>
			<!-- /ko -->
		</div>
	</div>
	<!-- /ko -->
</div>

<script>
	function Movie(data) {
		var self = this;
		self.title = data.title;
		self.year = data.year;
		self.rating = data.rating;
		self.releaseDate = data.releaseDate;
		self.runtime = data.runtime;
		self.director = data.director;
		self.writer = data.writer;
		self.actors = data.actors;
		self.plot = data.plot;
		self.language = data.language;
		self.country = data.country;
		self.awards = data.awards;
		self.poster = data.poster;
		self.metascore = data.metascore;
		self.imdbRating = data.imdbRating;
		self.imdbVotes = data.imdbVotes;
		self.imdbId = data.imdbId;
		self.type = data.type;
		return self;
	};
	function Genre(data) {
		var self = this;

		self.name = ko.observable(data.name);
		self.movies = ko.observableArray();
		$.ajax({
			method: 'GET',
			url: '<c:url value="/movies?genre="/>' + self.name() + "&page=0&size=6",
			success: function(data) {
				var tempMovies = [];
				for (i = 0; i < data.length; i++) {
					tempMovies.push(new Movie(data[i]));
				}
				self.movies(tempMovies);
			}
		});

		return self;
	};

	function ModelView() {
		var self = this;

		self.genres = ko.observableArray();
		$.ajax({
			method: 'GET',
			url: '<c:url value="/genres"/>',
			success: function(data) {
				var tempGenre = [];
				for (i = 0; i < data.length; i++) {
					tempGenre.push(new Genre(data[i]));
				}
				self.genres(tempGenre);
			}
		});

		return self;
	};
	$(function() {
		ko.applyBindings(new ModelView(), document.getElementById("mainContent"));
	});
</script>
</body>
</html>
