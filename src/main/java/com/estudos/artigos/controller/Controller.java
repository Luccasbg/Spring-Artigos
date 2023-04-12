package com.estudos.artigos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.artigos.dto.PostDto;
import com.estudos.artigos.dto.UserDto;
import com.estudos.artigos.models.Post;
import com.estudos.artigos.models.User;
import com.estudos.artigos.repository.PostRepository;
import com.estudos.artigos.repository.UserRepository;
import com.estudos.artigos.services.PostServices;
import com.estudos.artigos.services.UserServices;

@RestController
public class Controller {

    @Autowired
    private PostRepository repository;

    @Autowired
    private UserRepository userRepository;

    PostServices service = new PostServices();
    UserServices userServices = new UserServices();7

    //método para cadastro de usuários
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserDto userDto){
        User user = userServices.registerUser(userDto);
        userRepository.save(user);

        return ResponseEntity.ok().body("Usuário cadastrado com sucesso!");
    }

    //método para publicação de postagens + registro do autor pelo Id

    @PostMapping("/post/{id}")
    public ResponseEntity cadastrarPost(@PathVariable("id") Integer id, @RequestBody PostDto postDto){
        Post post = service.cadastrarPost(postDto);
        post.setIdAuthor(id);
        repository.save(post);

        return ResponseEntity.ok().body("Post publicado com sucesso!");
    }

    //método que exibe todas as postagens já realizadas na aplicação
    @GetMapping("/posts")
    public Iterable<Post> getPosts(){
        return repository.findAll();
    }

    //método para exibição de postagens com base no assunto especificado
    @GetMapping("/posts/{subject}")
    public Iterable<Post> getPostsBySubject(@PathVariable("subject") String subject ){
        return repository.findBySubject(subject);
    } 

    //método para exibição de postagens com base em seu autor
   @GetMapping("/posts/authors/{id}")
    public Iterable<Post> getPostsById_author(@PathVariable("id") Integer id){
        return repository.findByIdAuthor(id);
    }

    //método para deletar postagens com base em seu Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable("id") Integer id){
        repository.deleteById(id);
        
        return ResponseEntity.ok().body("Post deletado com sucesso!");
    }


}
