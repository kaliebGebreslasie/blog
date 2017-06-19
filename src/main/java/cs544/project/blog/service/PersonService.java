package cs544.project.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import cs544.project.blog.domain.Person;
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
}
