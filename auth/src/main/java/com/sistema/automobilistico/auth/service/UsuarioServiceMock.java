package com.sistema.automobilistico.auth.service;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceMock implements UsuarioService {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        Usuario usuario = new User();
        user1.setId(1);
        user1.se("admin");
        user1.setPassword("admin");

        users.add(user1);
    }

    @Override
    public User retrieveUserByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

}
