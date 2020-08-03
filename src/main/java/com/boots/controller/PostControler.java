package com.boots.controller;


import com.boots.entity.Post;
import com.boots.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 */
@Controller
public class PostControler {
    private final PostService postService;

    public PostControler(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postService.getAll());
        return "index";
    }
    @PostMapping("/save")
    public String addPost(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/";

    }
}
