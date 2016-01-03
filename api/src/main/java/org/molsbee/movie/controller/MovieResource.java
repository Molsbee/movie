package org.molsbee.movie.controller;

import lombok.extern.log4j.Log4j;
import org.molsbee.movie.model.Movie;
import org.molsbee.movie.model.omdb.TitleResponse;
import org.molsbee.movie.model.omdb.TitleSearchResponse;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET, params = {"genre", "page", "pagesize"})
    public ResponseEntity<List<Movie>> getMovies(@RequestParam("genre") String genre,
                                           @RequestParam(value = "page", required = true) int page,
                                           @RequestParam(value = "pagesize", required = true) int pagesize) {
        List<Movie> movies;
        if (genre != null) {
             movies = movieService.list(genre, page, pagesize);
        } else {
             movies = movieService.list(page, pagesize);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    public ResponseEntity<TitleResponse> getMovieByTitle(@PathVariable("title") String title) {
        TitleResponse omdbResponse = movieLookup.getMovieByTitle(title);
        return new ResponseEntity<>(omdbResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{title}", method = RequestMethod.GET)
    public ResponseEntity<List<TitleSearchResponse>> searchMovieByTitle(@PathVariable("title") String title) {
        List<TitleSearchResponse> titles = movieLookup.searchMovieByTitle(title);
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createMovie(@RequestBody TitleResponse titleResponse) {
        Movie movie = titleResponse.toMovie();
        movieService.save(movie);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
