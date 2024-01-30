package br.com.marqueswsm.springmvcjdbc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class user {
    @Id
    private String id;
    private String username;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public user(String id, String username) {
        this.id = id;
        this.username = username;
    }
}
