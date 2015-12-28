package com.molsbee.movie.security.repository;

import com.molsbee.movie.security.model.ServiceAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceAccountRepository extends JpaRepository<ServiceAccount, String> {

}
