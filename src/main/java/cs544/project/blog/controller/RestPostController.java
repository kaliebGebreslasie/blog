package cs544.project.blog.controller;

import java.security.Principal;
import java.util.Date;
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
import cs544.project.blog.service.PersonService;
import cs544.project.blog.service.PostService;
import cs544.project.blog.service.UserService;




@RestController
@RequestMapping("/api/post")
public class RestPostController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private UserService userService;
	@GetMapping(value="")
	public List<Post> getAll(){
		return postService.getAllOrderByDatecreated();
	}
	
	
	@GetMapping("/{id}")
	public Post readPost(@PathVariable long id){
		
		return postService.getById(id);
	}
	
	@GetMapping(value="/person/{id}")
	public List<Post> findByPerson(@PathVariable long id){
		Person person = personService.getById(id);
	return postService.getByPerson(person);
	}
	
	@PostMapping(value="/{username}")
	public Post savePost(@RequestBody Post post,@PathVariable String username){
		Person person=personService.getByUser(userService.getByUsername(username));
		post.setPerson(person);
		return postService.save(post);
	}
	
	@PutMapping(value="/update/{id}")
	public Post updatePost(@PathVariable long id, @RequestBody Post post){
		Post oldPost=postService.getById(id);
		post.setPerson(oldPost.getPerson());
		
	return postService.save(post);
	}

	@DeleteMapping(value="/delete/{id}")
	public void deletePost(@PathVariable long id){
		
		postService.delete(postService.getById(id));
	}
}


