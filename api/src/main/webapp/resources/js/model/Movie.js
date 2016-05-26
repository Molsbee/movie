function Movie(data) {
    var self = this;

    self.title = data.Title;
    self.year = data.Year;
    self.rating = data.Rated;
    self.released = data.Released;
    self.runtime = data.Runtime;
    self.genre = data.Genre;
    self.director = data.Director;
    self.writer = data.Writer;
    self.actors = data.Actors;
    self.plot = data.Plot;
    self.language = data.Language;
    self.country = data.Country;
    self.awards = data.Awards;
    self.poster = data.Poster;
    self.metascore = data.Metascore;
    self.imdbRating = data.imdbRating;
    self.imdbVotes = data.imdbVotes;
    self.imdbID = data.imdbID;
    self.type = data.Type;

    return self;
}

function SearchResponse(data) {
    var self = this;

    self.title = data.Title;
    self.year = data.Year;
    self.imdbId = data.imdbID;
    self.type = data.Type;
    self.poster = data.Poster;

    self.description = "Title: " + self.title + " Year: " + self.year;

    return self;
}
