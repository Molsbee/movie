package org.molsbee.movie.repository;

import org.molsbee.movie.model.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer> {

    public Movie findByTitle(String title);

}
