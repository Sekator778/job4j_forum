package com.boots.controller;


import com.boots.entity.Post;
import com.boots.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 */
@Controller
public class IndexController {
    private final PostService postService;

    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postService.getAll());
//        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "/index";
    }

    @PostMapping("/save")
    public String addPost(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit() {
        return "/edit";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Post post) {
        postService.update(post);
        return "redirect:/";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable String id) {
        postService.deletePostById(Long.parseLong(id));
        return "redirect:/";
    }
}
