package com.devocionais.devocionais.services;

import java.time.LocalDateTime;

import com.devocionais.devocionais.dto.PostDto;
import com.estudos.artigos.models.Post;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PostServices {

    public Post cadastrarPost(PostDto postDAO){
        Post post = new Post();
        BeanUtils.copyProperties(postDAO, post);
        post.setPublished_at(LocalDateTime.now());

        return post;
    }
    
}
