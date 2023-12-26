package ru.kata.spring.boot_security.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Collection;
import java.util.Collections;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private final User user;
    public UserDetails(User user) {
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRole();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getFirstName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    //для получения данных аутентефецированного пользователя;
    public User getUser(){
        return this.user;
    }
}
