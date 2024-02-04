package br.com.marqueswsm.springmvcjdbc.services;

import br.com.marqueswsm.springmvcjdbc.domain.User;
import br.com.marqueswsm.springmvcjdbc.repositories.GithubClient;
import br.com.marqueswsm.springmvcjdbc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GithubClient githubServiceClient;

    public User getUser(String username) {
        return githubServiceClient.getProfile(username);
    }
}
