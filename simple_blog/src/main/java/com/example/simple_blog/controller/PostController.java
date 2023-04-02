package com.example.simple_blog.controller;

import com.example.simple_blog.model.Post;
import com.example.simple_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Optional;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    public String newPost(Principal principal,
                          Model model) {
            Post post = new Post();

            model.addAttribute("post", post);

            return "/postForm";

    }

    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String createNewPost( Post post,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/postForm";
        } else {
            postService.save(post);
            return "redirect:/blog/";
        }
    }



    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(@PathVariable Long id) {

        Optional<Post> optionalPost = postService.findForId(id);
            Post post = optionalPost.get();
                postService.delete(post);
                return "redirect:/home";

    }

}