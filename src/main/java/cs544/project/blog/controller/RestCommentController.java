package cs544.project.blog.controller;

import java.security.Principal;
import java.util.Date;
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

import cs544.project.blog.domain.Comment;
import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.Post;
import cs544.project.blog.service.CommentService;
import cs544.project.blog.service.PersonService;
import cs544.project.blog.service.PostService;





@RestController
@RequestMapping("/api/comment")
public class RestCommentController {
	//@Autowired
//	private PostService postService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private PersonService personService;
	
	@GetMapping(value="")
	public List<Comment> getAll(){
		return commentService.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Comment getComment(@PathVariable long id){
		
		return commentService.getById(id);
	}
	
	@GetMapping(value="/person/{id}")
	public List<Comment> findByPerson(@PathVariable long id){
		Person person = personService.getById(id);
	return commentService.getByPerson(person);
	}
	
	@PostMapping(value="")
	public Comment saveComment(@RequestBody Comment comment){
		
		return commentService.save(comment);
	}
	
	/*@PutMapping(value="/update/{id}")
	public Post updatePost(@PathVariable long id, @RequestBody Post post){
		Post oldPost = postService.getById(id);
		
		oldPost=post;
		oldPost.setId(id);
		oldPost.setDateupdated(new Date());
	return postService.save(oldPost);
	}
*/
	@PostMapping(value="/delete/{id}")
	public void deleteComment(@PathVariable long id){
		commentService.delete(id);
	}
}


