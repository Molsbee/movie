<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>		
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css" />" media="screen" />
	<title>Add Movie</title>

	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
	
<body>
	<%@ include file="banner.jsp" %>

	<form class="form-horizontal" role="form" name="add-movie">
		<div class="form-group">
			<label class="col-sm-2 control-label" for="title">Title:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="title" placeholder="Example: Donnie Darko" data-bind="value: title">
            </div>
			<div class="col-sm-1">
				<button class="form-control btn btn-primary" id="search" data-bind="text: searchButton.text, disable: searchButton.disabled, click: searchButton.search"></button>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="year">Year:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="year" placeholder="Example: 2001" data-bind="value: year">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="rating">Rating:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="rating" placeholder="Example: R" data-bind="value: rating">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="released">Released:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="released" placeholder="Example: 30 Jan 2002" data-bind="value: released">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="runtime">Runtime:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="runtime" placeholder="Example: 113 min" data-bind="value: runtime">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="genre">Genre:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="genre" placeholder="Example: Drama, Mystery, Sci-Fi" data-bind="value: genre">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="director">Director:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="director" placeholder="Example: Richard Kelly" data-bind="value: director">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="writer">Writer:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="writer" placeholder="Example: Richard Kelly" data-bind="value: writer">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="actors">Actors:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="actors" placeholder="Example: Jake Gyllenhall, Holmes Osborne, Maggie Gyllenhaal, Daveigh Chase" data-bind="value: actors">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="plot">Plot:</label>
			<div class="col-sm-3">
				<textarea class="form-control" id="plot" rows="5" placeholder="Example: A troubled teenager is plagued by visions of a large bunny rabbit that manipulates him to commit a series of crimes, after narrowly escaping a bizarre accident." data-bind="value: plot"></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="language">Language:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="language" placeholder="Example: English" data-bind="value: language">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="country">Country:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="country" placeholder="Example: USA" data-bind="value: country">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="awards">Awards:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="awards" placeholder="Example: 11 wins & 12 nominations" data-bind="value: awards">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="poster">Poster:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="poster" placeholder="Example: http://ia.media-imdb.com/images/M/MV5BMTczMzE4Nzk3N15BMl5BanBnXkFtZTcwNDg5Mjc4NA@@._V1_SX300.jpg" data-bind="value: poster">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="metascore">Metascore:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="metascore" placeholder="Example: 71" data-bind="value: metascore">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="imdbRating">IMDB Rating:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="imdbRating" placeholder="Example: 8.1" data-bind="value: imdbRating">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="imdbVotes">IMDB Votes:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="imdbVotes" placeholder="Example: 454,083" data-bind="value: imdbVotes">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="imdbID">IMDB ID:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="imdbID" placeholder="Example: tt0246578" data-bind="value: imdbID">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="type">Type:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="type" placeholder="Example: movie" data-bind="value: type">
			</div>
		</div>
	</form>
	<div class="form-horizontal" role="form">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-1">
				<button class="form-control btn btn-primary" id="submit" data-bind="click: save">Submit</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.11.4/jquery-ui.min.js"></script>
	<script src="https://ajax.aspnetcdn.com/ajax/knockout/knockout-3.3.0.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/knockout-validation/2.0.3/knockout.validation.min.js"></script>
	<script src="<c:url value="/js/bootstrap.js" />"></script>
	<script>
        function SearchResponse(data) {
            var self = this;

            self.title = ko.observable(data.Title);
            self.year = ko.observable(data.Year);

            return this;
        }

        function SearchButton(parent) {
            var self = this;

            self.text = ko.observable("Search");
            self.disabled = ko.computed(function() {
                return self.text() == "Searching";
            });
            self.search = function() {
                self.text("Searching");
                $.ajax({
                    method: 'GET',
                    url: '<c:url value="/api/movie/title/"/>' + encodeURIComponent(parent.title()),
                    success: function(data) {
                        parent.year(data.Year);
                        parent.rating(data.Rated);
                        parent.released(data.Released);
                        parent.runtime(data.Runtime);
                        parent.genre(data.Genre);
                        parent.director(data.Director);
                        parent.writer(data.Writer);
                        parent.actors(data.Actors);
                        parent.plot(data.Plot);
                        parent.language(data.Language);
                        parent.country(data.Country);
                        parent.awards(data.Awards);
                        parent.poster(data.Poster);
                        parent.metascore(data.Metascore);
                        parent.imdbRating(data.imdbRating);
                        parent.imdbVotes(data.imdbVotes);
                        parent.imdbID(data.imdbID);
                        parent.type(data.Type);
                    },
                    complete: function() {
                        self.text("Search");
                    }
                });
            };

            return self;
        }

        function ModelView() {
			var self = this;

			self.title = ko.observable();
			self.year = ko.observable();
			self.rating = ko.observable();
			self.released = ko.observable();
			self.runtime = ko.observable();
			self.genre = ko.observable();
			self.director = ko.observable();
			self.writer = ko.observable();
			self.actors = ko.observable();
			self.plot = ko.observable();
			self.language = ko.observable();
			self.country = ko.observable();
			self.awards = ko.observable();
			self.poster = ko.observable();
			self.metascore = ko.observable();
			self.imdbRating = ko.observable();
			self.imdbVotes = ko.observable();
			self.imdbID = ko.observable();
			self.type = ko.observable();

			self.searchButton = new SearchButton(self);

            self.disabled = ko.computed(function() {
                return self.searchButton.disabled();
            });

            self.suggestions = ko.observableArray();
            self.search = function() {
                $.ajax({
                    method: 'GET',
                    url: '<c:url value="/api/movie/search/"/>' + encodeURIComponent(self.title()),
                    success: function (data) {
                        for (i = 0; i < data.length; i++) {
                            var tempSuggestions = [];
                            tempSuggestions.push(new SearchResponse(data[i]));
                        }
                        self.suggestions(tempSuggestions);
                    }
                });
            };

            self.save = function() {
				var request = {
					Title: self.title(),
					Year: self.year(),
					Rated: self.rating(),
					Released: self.released(),
					Runtime: self.runtime(),
                    Genre: self.genre(),
					Director: self.director(),
					Writer: self.writer(),
					Actors: self.actors(),
					Plot: self.plot(),
					Language: self.language(),
					Country: self.country(),
					Awards: self.awards(),
					Poster: self.poster(),
					Metascore: self.metascore(),
					imdbRating: self.imdbRating(),
					imdbVotes: self.imdbVotes(),
					imdbID: self.imdbID(),
					Type: self.type()
				};
                console.log(JSON.stringify(request));
				$.ajax({
					method: 'POST',
					url: '<c:url value="/api/movie"/>',
					data: JSON.stringify(request),
					dataType: 'json',
					contentType: 'application/json',
                    success: function(data, status) {
                        alert("success");
                    }
				});
			};

			return self;
		}
		$(function () {
			ko.applyBindings(new ModelView());
		});
	</script>
</body>
</html>