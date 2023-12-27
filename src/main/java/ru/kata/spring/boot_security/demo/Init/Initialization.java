package ru.kata.spring.boot_security.demo.Init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Initialization {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Initialization(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void addUsers() {
        Role roleUser = new Role("ROLE_USER");
        Role roleAdmin = new Role("ROLE_ADMIN");
        roleService.save(roleAdmin);
        roleService.save(roleUser);


        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleAdmin);
        User admin = new User("asd", "фыв", "На@Новый.год", "123", roleSet);
        String password = admin.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        admin.setPassword(encodedPassword);
        userService.createUser(admin);

        roleSet.remove(roleAdmin);
        roleSet.add(roleUser);
        User user = new User("Артур", "неХочет", "снова@На.завод", "пожить", roleSet);
        String password1 = user.getPassword();
        user.setPassword(passwordEncoder.encode(password1));
        userService.createUser(user);
    }
}

