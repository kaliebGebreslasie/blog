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
@RequestMapping("/api/user")
public class RestUserController {

	
	
	@Autowired
	private UserService userService;
	@GetMapping(value="")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username){
		
		return userService.getByUsername(username);
	}
	
	/*@GetMapping(value="/person/{id}")
	public List<Post> findByPerson(@PathVariable long id){
		Person person = personService.getById(id);
	return personService.getByPerson(person);
	}*/
	
	
}


