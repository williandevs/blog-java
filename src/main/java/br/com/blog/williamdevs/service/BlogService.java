package br.com.blog.williamdevs.service;

import java.util.List;


import br.com.blog.williamdevs.model.Post;

public interface BlogService {
    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);
    void deleteById(Long id);
   

}
