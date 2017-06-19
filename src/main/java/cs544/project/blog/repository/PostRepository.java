package cs544.project.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.project.blog.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
}
