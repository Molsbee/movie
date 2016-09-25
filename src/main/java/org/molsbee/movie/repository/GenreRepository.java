package org.molsbee.movie.repository;

import org.molsbee.movie.model.database.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, String> {
}
