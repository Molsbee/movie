package org.molsbee.movie.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "genre_name")
    private String genre;

}
