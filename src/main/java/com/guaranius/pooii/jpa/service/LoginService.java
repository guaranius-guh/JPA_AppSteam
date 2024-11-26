package com.guaranius.pooii.jpa.service;

import com.guaranius.pooii.jpa.entity.UserRole;
import com.guaranius.pooii.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var opt = userRepository.findByUsernameAndActiveTrue(username);
        if(opt.isEmpty()) {throw new UsernameNotFoundException(username);}
        var user = opt.get();
        var list = List.of(user.getRole());
        System.out.println(user);
        return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(list));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toList());
    }

}
