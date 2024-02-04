package br.com.marqueswsm.springmvcjdbc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String id;
    private String username;
    private String name;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLogin(String login) {
        this.setUsername(login);
    }

    public User(String id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }
}
