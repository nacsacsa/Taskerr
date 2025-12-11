package com.Tasker.Tasker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Tasker.Tasker.data.repository.usersRepository;
import com.Tasker.Tasker.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    usersRepository repository;

    @Override
    public UserDetailsService userDetailsService() {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return repository.findByEmail(username);
            }
        };
    }
}