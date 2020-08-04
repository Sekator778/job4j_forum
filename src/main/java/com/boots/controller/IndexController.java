package com.boots.controller;


import com.boots.entity.Post;
import com.boots.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Calendar;

/**
 * контролер для страниц которые изменяют данные
 */
@Controller
public class IndexController {
    private final PostService postService;

    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", postService.getAll());
//        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "index";
    }

    @PostMapping("/save")
    public String addPost(@ModelAttribute Post post) {
        post.setCreated(Calendar.getInstance());
        postService.addPost(post);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Post post) {
        post.setCreated(Calendar.getInstance());
        postService.update(post);
        return "redirect:/";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable String id) {
        postService.deletePostById(Long.parseLong(id));
        return "redirect:/";
    }
}
