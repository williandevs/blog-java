package br.com.blog.williamdevs.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.williamdevs.model.Post;
import br.com.blog.williamdevs.repository.BlogRepository;
import br.com.blog.williamdevs.service.BlogService;


@Service
public class BlogServiceImplemente implements BlogService {
    
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Post> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return blogRepository.save(post);
    }

  
    @Override
    public void deleteById(Long id) {
      blogRepository.deleteById(id);
        
    }


}
