package com.molsbee.movie.security.service;

import com.molsbee.movie.security.model.AccountAuthority;
import com.molsbee.movie.security.model.ServiceAccount;
import com.molsbee.movie.security.repository.ServiceAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceAccountDetails implements UserDetailsService {

    @Autowired
    private ServiceAccountRepository serviceAccountRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ServiceAccount serviceAccount = serviceAccountRepository.findOne(username);
        List<AccountAuthority> authorities = serviceAccount.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = authorities.stream().map(authority -> (GrantedAuthority) () -> authority.getAuthority()).collect(Collectors.toList());
        return new User(serviceAccount.getUsername(), serviceAccount.getPassword(), serviceAccount.isEnabled(), true, true, true, grantedAuthorities);
    }

}
