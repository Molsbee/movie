package org.molsbee.movie.service;

import lombok.extern.log4j.Log4j;
import org.molsbee.movie.model.database.Movie;
import org.molsbee.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Log4j
@Transactional
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> list(Optional<String> genre, OptionalInt page, OptionalInt size) {
        if (genre.isPresent()) {
            return findAllFilteredByGenre(genre.get(), page, size);
        }
        return findAll(page, size);
    }

    private List<Movie> findAllFilteredByGenre(String genre, OptionalInt page, OptionalInt size) {
        if (page.isPresent() && size.isPresent()) {
            return movieRepository.findByGenresName(genre, new PageRequest(page.getAsInt(), size.getAsInt(), Sort.Direction.DESC, "title"));
        }
        return movieRepository.findByGenresName(genre);
    }

    private List<Movie> findAll(OptionalInt page, OptionalInt size) {
        if (page.isPresent() && size.isPresent()) {
            Page<Movie> movies = movieRepository.findAll(new PageRequest(page.getAsInt(), size.getAsInt(), Sort.Direction.DESC, "title"));
            return movies.getContent();
        }
        return movieRepository.findAll();
    }

    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public Movie findById(Integer id) {
        return movieRepository.findOne(id);
    }

}
