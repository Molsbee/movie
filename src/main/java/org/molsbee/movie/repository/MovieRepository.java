package org.molsbee.movie.repository;

import org.molsbee.movie.model.database.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Stream<Movie> findByTitle(String title);

    Stream<Movie> findByGenresName(String name);

    Stream<Movie> findByGenresName(String name, Pageable pageable);

}
