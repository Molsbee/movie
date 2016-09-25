package org.molsbee.movie.model.security;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"authorities"})
@Entity
@Table(name = "service_accounts")
public class ServiceAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Setter(AccessLevel.NONE)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private List<AccountAuthority> authorities = new ArrayList<>();

    public List<AccountAuthority> getAuthorities() {
        return Collections.unmodifiableList(authorities);
    }

}
