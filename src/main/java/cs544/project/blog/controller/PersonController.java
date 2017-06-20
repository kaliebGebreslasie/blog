/*package cs544.project.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.User;
import cs544.project.blog.domain.UserRole;
import cs544.project.blog.service.PersonService;

@Controller
public class PersonController {
@Autowired
private PersonService personService;

@GetMapping({"/persons"})
public String homePage(Model model) {
	model.addAttribute("posts",personService.getAll());
	return "person";
}

@GetMapping({ "/person/{id}"})
public String getPost(@PathVariable int id, Model model) {
	

	model.addAttribute("person", personService.getById(id));
	
	return "";
}
@GetMapping({"/addPerson"})
public String addPerson(){
	
	User user=new User("w@gmai.com", "w", true);
	user.addUserRoles(new UserRole("ROLE_USER"));
	Person person=new Person("www","w@gmai.com",null,null,user);
	personService.save(person);
	
	return "redirect:/addPost";
	
}

}
*/