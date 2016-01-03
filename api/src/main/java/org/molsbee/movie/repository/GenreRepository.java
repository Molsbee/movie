package org.molsbee.movie.repository;

import org.molsbee.movie.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
}
