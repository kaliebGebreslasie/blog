package cs544.project.blog.repository;

import java.util.List;

import cs544.project.blog.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.project.blog.domain.Post;

import cs544.project.blog.domain.Person;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	public List<Post> findByOrderByDatecreatedDesc();
	public List<Post> findPostByPerson(Person person);
	public Post findDistinctPostByLikesEquals(Like like);
}
