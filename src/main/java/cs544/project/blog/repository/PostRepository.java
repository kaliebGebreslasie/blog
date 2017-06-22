package cs544.project.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.blog.domain.Post;

import cs544.project.blog.domain.Person;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface PostRepository extends JpaRepository<Post, Long>{
	List<Post> findByOrderByDatecreatedDesc();
	List<Post> findPostByPerson(Person person);
}
