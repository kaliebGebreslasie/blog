package cs544.project.blog.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.Post;
import cs544.project.blog.domain.User;
import cs544.project.blog.domain.UserRole;
import cs544.project.blog.service.PersonService;
import cs544.project.blog.service.PostService;





@RestController
@RequestMapping("/api/person")
public class RestPersonController {

	
	
	@Autowired
	private PersonService personService;
	@GetMapping(value="")
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable long id){
		
		return personService.getById(id);
	}
	
	/*@GetMapping(value="/person/{id}")
	public List<Post> findByPerson(@PathVariable long id){
		Person person = personService.getById(id);
	return personService.getByPerson(person);
	}*/
	
	@PostMapping(value="")
	public Person savePerson(@RequestBody Person person){
		System.out.println("userssssss"+person.getUser().getUsername());
	//User	 user=new User("w@gmai.com", "w", true);
	//	User user=person.getUser();
		//user.addUserRoles(new UserRole("ROLE_USER"));
		
		// person=new Person("www","w@gmai.com",null,null,user);
	return	personService.save(person);
	}
	
	@PutMapping(value="/update/{id}")
	public Person updatePerson(@PathVariable long id, @RequestBody Person person){
		
		Person oldPerson = personService.getById(id);
		oldPerson=person;
		oldPerson.setId(id);
	return personService.save(oldPerson);
	}

	@PostMapping(value="/delete/{id}")
	public void deletePerson(@PathVariable long id){
		personService.delete(id);
	}
}


