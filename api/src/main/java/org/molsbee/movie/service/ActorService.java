package org.molsbee.movie.service;

import org.molsbee.movie.model.Actor;
import org.molsbee.movie.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;


    public List<Actor> findOrCreate(String actors) {
        List<String> actorList = Arrays.asList(actors.split(","));

        return actorList.stream().map(a -> {
            String[] name = a.trim().split(" ");
            Actor actor = actorRepository.findByFirstNameAndLastName(name[0], name[1]);
            return Optional.ofNullable(actor).orElse(Actor.builder().firstName(name[0]).lastName(name[1]).build());
        }).collect(Collectors.toList());
    }
}
