package org.molsbee.movie.controller;

import org.molsbee.movie.model.omdb.TitleResponse;
import org.molsbee.movie.model.omdb.TitleSearchResponse;
import org.molsbee.movie.service.MovieLookup;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j
@RequestMapping(value = "/api/movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieResource {

    @Autowired
    private MovieLookup movieService;

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    public ResponseEntity<TitleResponse> getMovieByTitle(@PathVariable("title") String title) {
        TitleResponse omdbResponse = movieService.getMovieByTitle(title);
        return new ResponseEntity<>(omdbResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET, params = {"search"})
    public ResponseEntity<List<TitleSearchResponse>> searchMovieByTitle(@PathVariable("title") String title,
                                                                        @RequestParam(value = "search", required = true) String search) {
        List<TitleSearchResponse> titles = movieService.searchMovieByTitle(title);
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }

}
