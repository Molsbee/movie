package org.molsbee.movie.model.web;

import lombok.Data;
import org.molsbee.movie.model.Movie;
import org.molsbee.movie.omdb.Type;

import java.util.List;

@Data
public class CreateMovieRequest {

    private String title;
    private String year;
    private String rating;
    private String releaseDate;
    private String runtime;
    private List<String> genres;
    private String director;
    private String writer;
    private List<String> actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;
    private String metascore;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    private String type;

    public Movie toMovie() {
        return Movie.builder()
                .title(title)
                .year(year)
                .rating(rating)
                .releaseDate(releaseDate)
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
                .imdbVotes(imdbRating)
                .imdbID(imdbID)
                .type(Type.fromString(type))
                .build();
    }

}
