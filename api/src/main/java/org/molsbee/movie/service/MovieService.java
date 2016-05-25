package org.molsbee.movie.service;

import lombok.extern.log4j.Log4j;
import org.molsbee.movie.model.Movie;
import org.molsbee.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@Log4j
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Transactional
    public List<Movie> list(Optional<String> genre, OptionalInt page, OptionalInt size) {
        if (genre.isPresent()) {
            return findAllFilteredByGenre(genre.get(), page, size);
        }
        return findAll(page, size);
    }

    private List<Movie> findAllFilteredByGenre(String genre, OptionalInt page, OptionalInt size) {
        if (page.isPresent() && size.isPresent()) {
            return movieRepository.findByGenreName(genre, new PageRequest(page.getAsInt(), size.getAsInt(), Sort.Direction.DESC, "title"));
        }
        return movieRepository.findByGenreName(genre);
    }

    private List<Movie> findAll(OptionalInt page, OptionalInt size) {
        if (page.isPresent() && size.isPresent()) {
            Page<Movie> movies = movieRepository.findAll(new PageRequest(page.getAsInt(), size.getAsInt(), Sort.Direction.DESC, "title"));
            return movies.getContent();
        }
        return movieRepository.findAll();
    }

}
