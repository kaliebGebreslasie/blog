package cs544.project.blog.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import cs544.project.blog.service.UserService;

@RestController
@RequestMapping("/api/person")
public class RestPersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;
	
	@GetMapping(value = "")
	public List<Person> getAll() {
		return personService.getAll();
	}

	@GetMapping("/{id}")
	public Person getPerson(@PathVariable long id) {

		return personService.getById(id);
	}

	@GetMapping("/user/{username}")
	public Person getPersonByUser(@PathVariable String username){
		User user=userService.getByUsername(username);
		return personService.getByUser(user);
	}
	
	@GetMapping("/post/{id}")
	public Person getPersonByPost(@PathVariable long id){
		Post post=postService.getById(id);
		return personService.getByPost(post);
	}

	/*
	 * @GetMapping(value="/person/{id}") public List<Post>
	 * findByPerson(@PathVariable long id){ Person person =
	 * personService.getById(id); return personService.getByPerson(person); }
	 */

	@PostMapping(value = "")
	public Person savePerson(@RequestBody Person person) {
		System.out.println("userssssss" + person.getUser().getUsername());
		// User user=new User("w@gmai.com", "w", true);
		// User user=person.getUser();
		// user.addUserRoles(new UserRole("ROLE_USER"));

		// person=new Person("www","w@gmai.com",null,null,user);
		return personService.save(person);
	}

	@PutMapping(value = "/update/{id}")
	public Person updatePerson(@PathVariable long id, @RequestBody Person person) {

		Person oldPerson = personService.getById(id);
		person.setPosts(oldPerson.getPosts());

		System.out.println("title resful" + person.getId());
		return personService.save(person);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deletePerson(@PathVariable long id) {

		personService.delete(id);
	}
}
