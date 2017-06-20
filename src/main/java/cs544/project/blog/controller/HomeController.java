/*package cs544.project.blog.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.Post;
import cs544.project.blog.service.PostService;



@Controller
public class HomeController {
	@Autowired
	private PostService postService;
	@GetMapping({"/index", "/home","/"})
	public String homePage(Model model) {
		model.addAttribute("posts",postService.getAll());
		return "index";
	}
	@GetMapping("/post/{id}")
	public String readPost(@PathVariable long id, Model model){
		model.addAttribute("post", postService.getById(id));
		return "blogpost";
	}
	
	@GetMapping("/logout")
	public String logout(){
		return "index";
	}
	@GetMapping("/addPost")
	public String newPost(){
		return "addPost";
	}
	
	
@PostMapping({"/addPost"})
public String addPost(Post post){
	
	postService.save(post);
	
	return "redirect:/posts";
	
}



	
	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(Model model, Error error, String logout) {
		
	      //  if (error != null)
	        //    model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");
System.out.println("hellooooooooooooooooooo");
	        return "redirect:/products";
	    }
	 @GetMapping({"/registration"})
		public String registerPage() {
			return "home";
		}
}
*/