package com.devocionais.devocionais.repository;

import com.devocionais.devocionais.models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
    public Iterable<Post> findBySubject(String subject);
    public Iterable<Post> findByIdAuthor(Integer id_author);
    
}
