package org.molsbee.movie.controller;

import lombok.extern.log4j.Log4j;
import org.molsbee.movie.model.Genre;
import org.molsbee.movie.repository.GenreRepository;
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
    private GenreRepository genreRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Genre>> getGenres() {
        return new ResponseEntity(genreRepository.findAll(), HttpStatus.OK);
    }

}
