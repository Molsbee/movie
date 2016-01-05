package org.molsbee.movie.controller;

import lombok.extern.log4j.Log4j;
import org.molsbee.movie.model.Actor;
import org.molsbee.movie.model.Genre;
import org.molsbee.movie.model.Movie;
import org.molsbee.movie.model.omdb.TitleResponse;
import org.molsbee.movie.service.ActorService;
import org.molsbee.movie.service.GenreService;
import org.molsbee.movie.service.MovieLookup;
import org.molsbee.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j
@RequestMapping(value = "/api/movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieResource {

    @Autowired
    private MovieLookup movieLookup;

    @Autowired
    private MovieService movieService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private ActorService actorService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, params = {"genre", "page", "pagesize"})
    public ResponseEntity<List<Movie>> getMovies(@RequestParam(value = "genre", required = false) String genre,
                                           @RequestParam(value = "page") int page,
                                           @RequestParam(value = "pagesize") int pagesize) {
        List<Movie> movies = (genre != null) ? movieService.list(genre, page, pagesize) : movieService.list(page, pagesize);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // TODO Convert type to Enum
    /**
     * User for searching OMDB for a particular string either as a title lookup or pure
     * search.  The Type referes to the Search Type being performed (title or search)
     *
     * @param title
     * @param type (title, search)
     * @return
     */
    @RequestMapping(value = "/search/{title}", method = RequestMethod.GET, params = {"type"})
    public ResponseEntity<?> searchMovie(@PathVariable("title") String title, @RequestParam(value = "type", required = false) String type) {
        if (type.equalsIgnoreCase("title")) {
            return new ResponseEntity(movieLookup.getMovieByTitle(title), HttpStatus.OK);
        } else {
            return new ResponseEntity(movieLookup.searchMovieByTitle(title), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createMovie(@RequestBody TitleResponse titleResponse) {
        List<Genre> genres = genreService.findOrCreate(titleResponse.getGenre());
        List<Actor> actors = actorService.findOrCreate(titleResponse.getActors());

        Movie movie = titleResponse.toMovie();
        movie.setGenre(genres);
        movie.setActors(actors);

        movieService.save(movie);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
