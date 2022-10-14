package com.jwtsecurity.service;

import com.jwtsecurity.model.User;
import com.jwtsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        CustomUserDetails userDetails = null;

        if(user!=null){
            userDetails = new CustomUserDetails();
            userDetails.setUser(user);
        }
        else {
            throw new UsernameNotFoundException("User not exists");
        }
        return userDetails;
    }
}
