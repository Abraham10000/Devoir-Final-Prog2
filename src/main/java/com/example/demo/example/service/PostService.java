package com.example.demo.example.service;


import com.example.demo.example.model.Post;
import com.example.demo.example.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    public Post getById(Long postId){
        return repository.getReferenceById(postId);
    }

    public List<Post> getAll(){
        return repository.findAll();
    }

    @Transactional
    public List<Post> saveAll(List<Post> posts){
        return repository.saveAll(posts);
    }

    public List<Post> getPostsByUserId(Long userId){
        return repository.findByUserId(userId);
    }
}