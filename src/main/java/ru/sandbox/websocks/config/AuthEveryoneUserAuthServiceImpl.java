package ru.sandbox.websocks.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthEveryoneUserAuthServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) {
        return new User(username, "", Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
}
