package cs544.project.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.project.blog.domain.Person;

@Repository
public interface ServiceRepository extends JpaRepository<Person, Long>{

	public List<Person> findByEmail(String email);
	public List<Person> findByName(String name);
	
		
}
