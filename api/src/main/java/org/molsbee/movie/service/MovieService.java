package org.molsbee.movie.service;

import lombok.extern.log4j.Log4j;
import org.molsbee.movie.model.Movie;
import org.molsbee.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public void save(Movie movie) {
        log.debug("Saving Movie: "  + movie.getTitle());
        movieRepository.save(movie);
    }

}
