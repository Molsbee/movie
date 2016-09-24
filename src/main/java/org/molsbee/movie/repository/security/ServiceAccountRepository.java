package org.molsbee.movie.repository.security;

import org.molsbee.movie.model.security.ServiceAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceAccountRepository extends JpaRepository<ServiceAccount, String> {

}
