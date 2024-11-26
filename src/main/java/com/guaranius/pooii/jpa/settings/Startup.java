package com.guaranius.pooii.jpa.settings;

import com.guaranius.pooii.jpa.entity.User;
import com.guaranius.pooii.jpa.entity.UserRole;
import com.guaranius.pooii.jpa.repository.UserRepository;
import com.guaranius.pooii.jpa.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Startup {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(userRoleRepository.findAll().isEmpty()){
            UserRole userRole = new UserRole();
            userRole.setCode("ROLE_ADMIN");
            userRole.setName("Administrador");
            userRoleRepository.save(userRole);
            userRole = new UserRole();
            userRole.setCode("ROLE_USER");
            userRole.setName("Usuário");
            userRoleRepository.save(userRole);
        }
    }
}
