package com.boots.service;


import com.boots.entity.Post;
import com.boots.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository repository;

    /**
     * @return ALL  posts
     */
    public List<Post> getAll() {
        return repository.findAll();
    }

    public void addPost(Post post) {
        repository.saveAndFlush(post);
    }

    public void update(Post post) {
        repository.deleteById(post.getId());
        repository.saveAndFlush(post);
    }

    public void deletePostById(Long id) {
        repository.deleteById(id);
    }
}