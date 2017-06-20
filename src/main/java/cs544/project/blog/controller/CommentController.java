/*package cs544.project.blog.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.project.blog.domain.Comment;
import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.Post;
import cs544.project.blog.service.CommentService;
import cs544.project.blog.service.PersonService;
import cs544.project.blog.service.PostService;

@Controller
public class CommentController {
@Autowired
private CommentService commentService;
private PostService postService;

@GetMapping({ "/comment/{postid}"})
public String getPost(@PathVariable int postid, Model model) {
	

	//model.addAttribute("person", personService.getById(id));
	
	return "";
}

@PostMapping({"/addComment/{id}"})
public String addComment(@PathVariable int id,@RequestParam String content,Principal p){
	//Post post
	Person person =new Person();
	//Person person=p.getName()
	Comment comment= new Comment(content, new Date(), null,person);
	Post post=postService.getById(id);
	post.addComment(comment);
	postService.save(post);
	//commentService.save(comment);
	
	return "redirect:/posts";
	
}

}
*/