package com.molsbee.movie.controller;

import com.molsbee.movie.model.OmdbResponse;
import com.molsbee.movie.service.MovieLookup;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Log4j
@RequestMapping(value = "/api/movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieResource {

    @Autowired
    private MovieLookup movieService;

    @RequestMapping(value = "/title/{movieTitle}", method = RequestMethod.GET)
    public ResponseEntity<OmdbResponse> getMovieByTitle(@PathVariable("movieTitle") String movieTitle) {
        OmdbResponse omdbResponse = omdbResponse = movieService.getMovieByTitle(movieTitle);
        return new ResponseEntity<>(omdbResponse, HttpStatus.OK);
    }

}
