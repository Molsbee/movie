package org.molsbee.movie.service;

import org.molsbee.movie.model.Genre;
import org.molsbee.movie.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> findOrCreate(String genres) {
        List<String> genreList = Arrays.asList(genres.split(","));
        return genreList.stream().map(g -> Optional.ofNullable(genreRepository.findOne(g.trim())).orElse(new Genre(g.trim()))).collect(Collectors.toList());
    }

}
