package cs544.project.blog.service;

import java.util.List;

import cs544.project.blog.domain.Comment;
import cs544.project.blog.domain.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.User;
import cs544.project.blog.repository.PersonRepository;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public Person getById(long id){
		return personRepository.findOne(id);
	}
	
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	
	public Person save(Person person){
		return personRepository.save(person);
	}
	
	public void delete(long id){
		personRepository.delete(id);
	}
	
	public long count(){
		return personRepository.count();
	}
	
	public boolean exists(long id){
		return personRepository.exists(id);
	}
	
	public Person getByUser(User user ){
	return personRepository.findPostByUser(user);
	}

	public Person getByComment(Comment comment) { return personRepository.findDistinctPersonByCommentsEquals(comment);}

	public Person getByLike(Like like) { return personRepository.findDistictPersonByLikesEquals(like); }

	public Person getByName(String name) { return personRepository.findDistinctPersonByName(name);}
}
