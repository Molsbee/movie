package org.molsbee.movie.repository;

import org.molsbee.movie.model.database.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Optional<Actor> findByFirstNameAndLastName(String firstName, String lastName);

}
