package org.molsbee.movie.service;

import org.molsbee.movie.model.Actor;
import org.molsbee.movie.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;


    public List<Actor> findOrCreate(List<String> actors) {
        List<Actor> actorList = actors.stream().map(a -> {
            String[] name = a.trim().split(" ");
            String firstName = name[0];
            String lastName = name[1];
            Actor actor =  actorRepository.findByFirstNameAndLastName(firstName, lastName);
            return Optional.ofNullable(actor)
                    .orElse(Actor.builder().firstName(firstName).lastName(lastName).build());
        }).collect(Collectors.toList());

        return actorRepository.save(actorList);
    }
}
