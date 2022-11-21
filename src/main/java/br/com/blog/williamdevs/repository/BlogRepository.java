package br.com.blog.williamdevs.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.williamdevs.model.Post;

@Repository
public interface BlogRepository extends JpaRepository<Post, Long> {
}