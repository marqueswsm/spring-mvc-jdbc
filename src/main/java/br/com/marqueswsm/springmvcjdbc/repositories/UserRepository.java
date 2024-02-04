package br.com.marqueswsm.springmvcjdbc.repositories;

import br.com.marqueswsm.springmvcjdbc.domain.User;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM github_users where username = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);
}

