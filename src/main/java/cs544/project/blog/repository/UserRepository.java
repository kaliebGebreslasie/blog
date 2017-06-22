package cs544.project.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.blog.domain.Comment;
import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.User;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface UserRepository extends JpaRepository<User, Long>{
//List<Comment> getCommentByPerson(Person person); 
	
	public User findUserByUsername(String username);
	public List<User> findByUserRoles(String userRoles);
}
