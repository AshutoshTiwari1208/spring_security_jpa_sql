package com.inclined.springsecurityjpa;

import com.inclined.springsecurityjpa.model.User;
import com.inclined.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.getUserByUserName(username);
        userOptional.orElseThrow(()-> new UsernameNotFoundException("User not found!"));
        User user = userOptional.get();
        return new MyUserDetails(user);
    }

}
