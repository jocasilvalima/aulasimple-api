package com.joaocarlos.aulasimple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaocarlos.aulasimple.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
