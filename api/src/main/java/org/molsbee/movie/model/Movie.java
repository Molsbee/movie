package org.molsbee.movie.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;
import org.molsbee.movie.omdb.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "rating")
    private String rating;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "runtime")
    private String runtime;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Genre> genre =  new ArrayList<>();

    @Column(name = "director")
    private String director;

    @Column(name = "writer")
    private String writer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_actors",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Actor> actors = new ArrayList<>();

    @Column(name = "plot")
    private String plot;

    @Column(name = "language")
    private String language;

    @Column(name = "country")
    private String country;

    @Column(name = "awards")
    private String awards;

    @Column(name = "poster")
    private String poster;

    @Column(name = "metascore")
    private String metascore;

    @Column(name = "imdbRating")
    private String imdbRating;

    @Column(name = "imdbVotes")
    private String imdbVotes;

    @Column(name = "imdbId")
    private String imdbId;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Builder
    public Movie(String title, String year, String rating, String releaseDate, String runtime, List<Genre> genre,
                 String director, String writer, List<Actor> actors, String plot, String language, String country,
                 String awards ,String poster, String metascore, String imdbRating, String imdbVotes, String imdbId, Type type) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbId = imdbId;
        this.type = type;
    }

}
