package org.molsbee.movie.model.security;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "account_authorities")
public class AccountAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    private Authority authority;

}
