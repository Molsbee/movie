package org.molsbee.movie.service;

import lombok.extern.log4j.Log4j;
import org.molsbee.movie.model.Movie;
import org.molsbee.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public List<Movie> list(String genre, int page, int size) {
        return movieRepository.findByGenreName(genre, new PageRequest(page, size, Sort.Direction.DESC, "title"));
    }

    @Transactional
    public List<Movie> list(int page, int size) {
        return (List<Movie>) movieRepository.findAll(new PageRequest(page, size, Sort.Direction.DESC));
    }

}
