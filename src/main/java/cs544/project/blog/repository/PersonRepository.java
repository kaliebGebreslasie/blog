package cs544.project.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.User;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	public Person findPostByUser(User user);
	public List<Person> findByName(String name);
	
		
}
