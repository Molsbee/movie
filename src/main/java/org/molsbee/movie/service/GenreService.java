package org.molsbee.movie.service;

import org.molsbee.movie.model.Genre;
import org.molsbee.movie.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    public List<Genre> findOrCreate(List<String> genres) {
        List<Genre> genreList = genres.stream().map(g -> {
            String genre = g.trim();
            return Optional.ofNullable(genreRepository.findOne(genre))
                    .orElse(new Genre(genre));
        }).collect(Collectors.toList());

        return genreRepository.save(genreList);
    }

}
