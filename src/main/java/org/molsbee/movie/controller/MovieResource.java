package org.molsbee.movie.controller;

import lombok.extern.log4j.Log4j;
import org.molsbee.movie.model.Actor;
import org.molsbee.movie.model.Genre;
import org.molsbee.movie.model.Movie;
import org.molsbee.movie.model.web.CreateMovieRequest;
import org.molsbee.movie.service.ActorService;
import org.molsbee.movie.service.GenreService;
import org.molsbee.movie.service.MovieService;
import org.molsbee.movie.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Controller
@Log4j
@RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieResource {

    @Autowired
    private OmdbService movieLookup;

    @Autowired
    private MovieService movieService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private ActorService actorService;

    @RequestMapping(method = RequestMethod.GET, params = {"genre", "page", "size"})
    public ResponseEntity<List<Movie>> getMovies(@RequestParam(value = "genre", required = false) String genre,
                                    @RequestParam(value = "page", required = false) Integer page,
                                    @RequestParam(value = "size", required = false) Integer size) {
        List<Movie> movies = movieService.list(Optional.ofNullable(genre), OptionalInt.of(page), OptionalInt.of(size));
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    public ResponseEntity<Movie> findByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.findByTitle(title);
        return new ResponseEntity(movies, HttpStatus.OK);
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<Movie> findByMovieId(@PathVariable Integer id) {
        Movie movie = movieService.findById(id);
        return new ResponseEntity(movie, HttpStatus.OK);
    }

    // TODO Convert type to Enum
    /**
     * User for searching OMDB for a particular string either as a title lookup or pure
     * search.  The Type refers to the Search Type being performed (title or search)
     *
     * @param title
     * @param type (title, search)
     * @return
     */
    @RequestMapping(value = "/search/{title}", method = RequestMethod.GET, params = {"type"})
    public ResponseEntity searchMovie(@PathVariable("title") String title,
                                      @RequestParam(value = "type", required = false) String type) {
        if (type.equalsIgnoreCase("title")) {
            return new ResponseEntity(movieLookup.getMovieByTitle(title), HttpStatus.OK);
        } else {
            return new ResponseEntity(movieLookup.searchMovieByTitle(title), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Movie> createMovie(@RequestBody CreateMovieRequest createMovieRequest) {
        List<Genre> genres = genreService.findOrCreate(createMovieRequest.getGenres());
        List<Actor> actors = actorService.findOrCreate(createMovieRequest.getActors());

        Movie movie = createMovieRequest.toMovie();
        movie.setGenres(genres);
        movie.setActors(actors);

        movie = movieService.save(movie);
        return new ResponseEntity(movie, HttpStatus.OK);
    }

}
