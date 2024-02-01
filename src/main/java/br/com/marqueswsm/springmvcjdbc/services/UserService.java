package br.com.marqueswsm.springmvcjdbc.services;

import br.com.marqueswsm.springmvcjdbc.domain.User;
import br.com.marqueswsm.springmvcjdbc.repositories.Github;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private User userRepository;

    @Autowired
    private Github githubUser;

    public User getUser(String username) {
        return this.githubUser.getProfile(username);
    }
}
