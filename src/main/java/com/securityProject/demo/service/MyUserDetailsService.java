package com.securityProject.demo.service;

import com.securityProject.demo.model.User;
import com.securityProject.demo.model.UserPrinciple;
import com.securityProject.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);

        if (user == null){
            System.out.println("Not Found User");
            throw new UsernameNotFoundException("Not Found Username");
        }

        return new UserPrinciple(user);
    }
}
