package br.com.marqueswsm.springmvcjdbc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface User extends JpaRepository<User, String> {}
