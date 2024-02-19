package br.com.marqueswsm.springmvcjdbc.services;

import br.com.marqueswsm.springmvcjdbc.domain.User;
import br.com.marqueswsm.springmvcjdbc.repositories.GithubClient;
import br.com.marqueswsm.springmvcjdbc.repositories.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private GithubClient githubServiceClient;

    @Autowired
    private JdbcRepository jdbcRepository;

    public User getUser(String username) {
        final User user = githubServiceClient.getProfile(username);
        jdbcRepository.save(user);
        return user;
    }

    public User getUserInternal(String username) {
        return jdbcRepository.findByUsername(username);
    }

    public void deleteUser(String username) {
        jdbcRepository.deleteUser(username);
    }
}
