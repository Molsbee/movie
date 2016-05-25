package org.molsbee.movie.repository;

import org.molsbee.movie.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Actor findByFirstNameAndLastName(String firstName, String lastName);

}
