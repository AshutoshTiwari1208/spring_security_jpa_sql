package com.inclined.springsecurityjpa;

import com.inclined.springsecurityjpa.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<SimpleGrantedAuthority> roles;
    private boolean active;

    public MyUserDetails(User user) {
        this.username = user.getUserName();
        this.active = user.getActive() == 1 ? true : false;
        this.password = user.getPassword();
        this.roles = Arrays.stream(user.getRoles().split(","))
                    .map(data-> new SimpleGrantedAuthority(data))
                    .collect(Collectors.toList());
    }

    public MyUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.active;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
