package org.molsbee.movie.repository;

import org.molsbee.movie.model.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer> {

    Movie findByTitle(String title);

    List<Movie> findByGenreName(String name, Pageable pageable);

}
