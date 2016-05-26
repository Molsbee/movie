package org.molsbee.movie.model.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.molsbee.movie.model.Movie;
import org.molsbee.movie.omdb.Type;

import java.util.Arrays;
import java.util.List;

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
    private String genres;

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
        return Movie.builder()
                .title(title)
                .year(year)
                .rating(rated)
                .releaseDate(released)
                .runtime(runtime)
                .director(director)
                .writer(writer)
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

    public List<String> getGenres() {
        return Arrays.asList(genres.split(","));
    }

    public List<String> getActors() {
        return Arrays.asList(actors.split(","));
    }

}
