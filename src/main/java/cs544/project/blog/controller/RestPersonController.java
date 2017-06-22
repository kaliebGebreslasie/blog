package cs544.project.blog.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cs544.project.blog.domain.*;
import cs544.project.blog.service.CommentService;
import cs544.project.blog.service.LikeService;
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

import cs544.project.blog.service.PersonService;
import cs544.project.blog.service.PostService;





@RestController
@RequestMapping("/api/person")
public class RestPersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private LikeService likeService;

	@GetMapping(value="")
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable long id){
		
		return personService.getById(id);
	}

	@GetMapping("/name/{name}")
	public Person getByName(@PathVariable String name){
		return personService.getByName(name);
	}

	@GetMapping("/comment/{id}")
	public Person getByComment(@PathVariable long id){
		Comment comment = commentService.getById(id);
		return personService.getByComment(comment);
	}

	@GetMapping("/like/{id}")
	public Person getByLike(@PathVariable long id){
		Like like = likeService.getById(id);
		return personService.getByLike(like);
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


