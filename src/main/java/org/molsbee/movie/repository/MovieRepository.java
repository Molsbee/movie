package org.molsbee.movie.repository;

import org.molsbee.movie.model.database.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByTitle(String title);

    List<Movie> findByGenresName(String name);

    List<Movie> findByGenresName(String name, Pageable pageable);

}
