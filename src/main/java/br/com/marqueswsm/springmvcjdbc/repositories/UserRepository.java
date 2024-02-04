package br.com.marqueswsm.springmvcjdbc.repositories;

import br.com.marqueswsm.springmvcjdbc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {}
