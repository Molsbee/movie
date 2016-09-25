package org.molsbee.movie.controller;

import lombok.extern.log4j.Log4j;
import org.molsbee.movie.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Log4j
@RequestMapping(value = "/genres", produces = MediaType.APPLICATION_JSON_VALUE)
public class GenreResource {

    @Autowired
    private GenreService genreService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getGenres() {
        return new ResponseEntity(genreService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(List<String> genres) {
        genreService.findOrCreate(genres);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
