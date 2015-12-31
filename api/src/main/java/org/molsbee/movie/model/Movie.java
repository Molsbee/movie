package org.molsbee.movie.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.molsbee.movie.omdb.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"genre", "actors"})
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

    @ManyToMany
    @JoinTable(name = "movie_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Genre> genre =  new ArrayList<>();

    @Column(name = "director")
    private String director;

    @Column(name = "writer")
    private String writer;

    @ManyToMany
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

}
