package br.com.marqueswsm.springmvcjdbc.repositories;

import br.com.marqueswsm.springmvcjdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "insert into github_users (id, username, name) values (?,?,?)";

        template.update(sql, user.getId(), user.getUsername(), user.getName());
    }

    public void deleteUser(String username) {
        String sql = "delete from github_users where username = ?";

        template.update(sql, username);
    }
}
