package org.molsbee.movie.model.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.molsbee.movie.model.Actor;
import org.molsbee.movie.model.Genre;
import org.molsbee.movie.model.Movie;
import org.molsbee.movie.omdb.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonIgnoreProperties(value = {"Response"})
public class TitleResponse {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Rated")
    private String rated;

    @JsonProperty("Released")
    private String released;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Writer")
    private String writer;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Awards")
    private String awards;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Metascore")
    private String metascore;

    private String imdbRating;

    private String imdbVotes;

    @JsonProperty("imdbID")
    private String imdbId;

    @JsonProperty("Type")
    private String type;

    public Movie toMovie() {
        List<String> actorList = Arrays.asList(actors.split(","));
        List<String> genreList = Arrays.asList(genre.split(","));

        return Movie.builder()
                .title(title)
                .year(year)
                .rating(rated)
                .releaseDate(released)
                .runtime(runtime)
                .genre(genreList.stream().map(g -> {
                    g = g.trim();
                    return new Genre(g);
                }).collect(Collectors.toList()))
                .director(director)
                .writer(writer)
                .actors(actorList.stream().map(a -> {
                    a = a.trim();
                    String[] names = a.split(" ");
                    return Actor.builder().firstName(names[0]).lastName(names[1]).build();
                }).collect(Collectors.toList()))
                .plot(plot)
                .language(language)
                .country(country)
                .awards(awards)
                .poster(poster)
                .metascore(metascore)
                .imdbRating(imdbRating)
                .imdbVotes(imdbVotes)
                .imdbId(imdbId)
                .type(Type.fromString(type))
                .build();
    }

}
