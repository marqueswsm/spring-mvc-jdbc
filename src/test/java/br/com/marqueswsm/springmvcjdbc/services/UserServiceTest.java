package br.com.marqueswsm.springmvcjdbc.services;

import br.com.marqueswsm.springmvcjdbc.domain.User;
import br.com.marqueswsm.springmvcjdbc.repositories.GithubClient;
import br.com.marqueswsm.springmvcjdbc.repositories.JdbcRepository;
import java.util.UUID;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private JdbcRepository jdbcRepository;

    @Mock
    private GithubClient githubClient;

    @Autowired
    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserAndSaveInternally() {
        User user = createUser();
        when(githubClient.getProfile("marqueswsm")).thenReturn(user);
        doNothing().when(jdbcRepository).save(any(User.class));

        User userFromGithub = userService.getUser("marqueswsm");

        assertEquals(user, userFromGithub);
        verify(githubClient, times(1)).getProfile(user.getUsername());
        verify(jdbcRepository, times(1)).save(user);
    }

    @Test
    void getUserInternal() {
        User user = createUser();
        when(jdbcRepository.findByUsername(user.getUsername())).thenReturn(user);

        User userFromRepository = userService.getUserInternal("marqueswsm");

        assertEquals(user, userFromRepository);
        verify(jdbcRepository, times(1)).findByUsername(user.getUsername());
    }

    @Test
    void deleteUser() {
        User user = createUser();
        doNothing().when(jdbcRepository).deleteUser(user.getUsername());

        assertDoesNotThrow(() -> userService.deleteUser(user.getUsername()));
        verify(jdbcRepository, times(1)).deleteUser(user.getUsername());
    }

    private User createUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("marqueswsm");
        user.setName("Wanderson Marques");

        return user;
    }
}
