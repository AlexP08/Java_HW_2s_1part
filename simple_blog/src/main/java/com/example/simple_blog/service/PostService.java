package com.example.simple_blog.service;

import com.example.simple_blog.model.Post;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService {

    Optional<Post> findForId(Long id);

    Post save(Post post);

    Page<Post> findAllOrderedByDatePageable(int page);

    void delete(Post post);
}