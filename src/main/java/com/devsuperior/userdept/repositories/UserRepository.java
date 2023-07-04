package com.devsuperior.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.userdept.entities.User;

// interface, acesso aos dados.
public interface UserRepository extends JpaRepository<User, Long> {

}
