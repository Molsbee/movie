package org.molsbee.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "genre")
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    @Id
    @Column(name = "genre_name")
    private String name;

}
