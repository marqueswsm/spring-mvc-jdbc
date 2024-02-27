package br.com.marqueswsm.springmvcjdbc.repositories;

import br.com.marqueswsm.springmvcjdbc.domain.User;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {

    private JdbcTemplate template;

    private final RowMapper<User> userRowMapper = (result, rowNum) -> {
        User user = new User();
        user.setId(result.getString("id"));
        user.setUsername(result.getString("username"));
        user.setName(result.getString("name"));
        return user;
    };

    @Autowired
    public void setTemplate(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "insert into github_users (id, username, name) values (?,?,?)";

        template.update(sql, user.getId(), user.getUsername(), user.getName());
    }

    public User findByUsername(String username) {
        String sql = "select * from github_users where username = ?";

        return template.queryForObject(sql, userRowMapper, username);
    }

    public void deleteUser(String username) {
        String sql = "delete from github_users where username = ?";

        template.update(sql, username);
    }
}
