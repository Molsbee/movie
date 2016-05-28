<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="navbar">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" style="color:red">MOLSBEE-FLIX</a>
		</div>

		<div class="collapse navbar-collapse" id="banner-navbar-collapse">
			<ul id="multicol-menu" class="nav navbar-nav">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="color:red">Browse <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li>
							<div class="row" style="width: 600px;">
								<ul id="pages" class="list-unstyled col-md-2">
									<li><a href="<c:url value="/"/>">Home</a></li>
									<li><a href="<c:url value="/create"/>">Create</a></li>
								</ul>
								<ul id="movies-1" class="list-unstyled col-md-5">
									<li>Movie Genres</li>
									<li class="divider"></li>
									<li>Action &amp; Adventure</li>
									<li>Comedies</li>
									<li>Dramas</li>
									<li>Horror</li>
								</ul>
								<ul id="movies-2" class="list-unstyled col-md-5">
									<li>&nbsp;</li>
									<li class="divider"></li>
									<li>Romance</li>
									<li>Sci-Fi &amp; Fantasy</li>
									<li>Sports Movies</li>
									<li>Thrillers</li>
								</ul>
							</div>
						</li>
					</ul>
				</li>
			</ul>
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search" data-bind="title">
				</div>
				<button type="submit" class="btn btn-danger" data-bind="click: search">Submit</button>
			</form>
		</div>
	</div>
</nav>
<div class="row" style="padding-bottom: 70px"></div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.11.4/jquery-ui.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/knockout/knockout-3.3.0.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/knockout-validation/2.0.3/knockout.validation.min.js"></script>
<script src="<c:url value="/js/bootstrap.js" />"></script>

<script>
	function Genre(data) {
		var self = this;
		self.name = data.name;
		return self;
	}

	function ViewModel() {
		var self = this;

		self.genres = ko.observableArray();
		$.ajax({
			method: 'GET',
			url: '<c:url value="/genres"/>',
			success: function(data) {
				var genres = [];
				for (i = 0; i < data.length; i++) {
					var genre = new Genre(data[i]);
					console.log(genre)
					genres.push(genre);
				}
				self.genres(genres);
			}
		});

		self.title = ko.observable();
		self.search = function() {
			$.ajax({
				method: 'GET',
				url: '<c:url value="/movies/"/>' + self.title(),
				success: function(data) {
					// TODO: Do Something
					console.log(data)
				}
			})
		}

		return self;
	}

	$(function() {
		ko.applyBindings(new ViewModel(), document.getElementById("navbar"));
	})
</script>