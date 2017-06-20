package cs544.project.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.User;
import cs544.project.blog.repository.PersonRepository;
import cs544.project.blog.repository.UserRepository;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User getById(long id){
		return userRepository.findOne(id);
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User save(User user){
		return userRepository.save(user);
	}
	
	public void delete(long id){
		userRepository.delete(id);
	}
	
	public long count(){
		return userRepository.count();
	}
	
	public boolean exists(long id){
		return userRepository.exists(id);
	}
	public User getByUsername(String username){
		return userRepository.findUserByUsername(username);
	}
}
