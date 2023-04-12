package com.devocionais.devocionais.repository;

import com.devocionais.devocionais.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Iterable<User> findByFullname(String fullname);
}
