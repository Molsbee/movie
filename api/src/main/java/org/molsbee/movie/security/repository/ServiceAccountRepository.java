package org.molsbee.movie.security.repository;

import org.molsbee.movie.security.model.ServiceAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceAccountRepository extends JpaRepository<ServiceAccount, String> {

}
