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
<%@ include file="banner.jsp"%>

<div data-bind="foreach: genres">
	<div class="row" style="padding-top: 20px">
		<div class="col-md-3" data-bind="foreach: movies">
			<a href-="#" class="thumbnail">
				<img data-bind="attr: {src: poster}">
			</a>
		</div>
	</div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.11.4/jquery-ui.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/knockout/knockout-3.3.0.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/knockout-validation/2.0.3/knockout.validation.min.js"></script>
<script src="<c:url value="/js/bootstrap.js" />"></script>
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
			url: '<c:url value="/api/movie/list/"/>' + "?genre=" + self.name() + "&page=0&pagesize=4",
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
			url: '<c:url value="/api/genre/list"/>',
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
		ko.applyBindings(new ModelView());
	});
</script>
</body>
</html>
