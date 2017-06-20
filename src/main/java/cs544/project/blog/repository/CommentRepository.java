package cs544.project.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.project.blog.domain.Comment;
import cs544.project.blog.domain.Person;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
List<Comment> getCommentByPerson(Person person); 
}
