package org.molsbee.movie.repository;

import org.molsbee.movie.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

    Actor findByFirstNameAndLastName(String firstName, String lastName);

}
