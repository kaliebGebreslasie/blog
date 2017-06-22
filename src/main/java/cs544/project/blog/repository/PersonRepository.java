package cs544.project.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.Post;
import cs544.project.blog.domain.User;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface PersonRepository extends JpaRepository<Person, Long>{

	public Person findPersonByUser(User user);
	
	public List<Person> findByName(String name);
	public Person findPersonByPosts(Post post);
	
		
}
