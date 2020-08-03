package com.boots.service;


import com.boots.entity.Post;
import com.boots.repository.PostRepository;
import com.boots.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @PersistenceContext
    private EntityManager em;
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
}