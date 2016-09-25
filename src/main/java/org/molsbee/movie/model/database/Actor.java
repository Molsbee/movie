package org.molsbee.movie.model.database;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "actor")
@Data
@NoArgsConstructor
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Builder
    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
