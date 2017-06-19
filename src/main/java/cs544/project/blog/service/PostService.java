package cs544.project.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import cs544.project.blog.domain.Post;
import cs544.project.blog.repository.PostRepository;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public Post getById(long id){
		return postRepository.findOne(id);
	}
	
	public List<Post> getAll(){
		return postRepository.findAll();
	}
	
	public Post save(Post post){
		return postRepository.save(post);
	}
	
	public void delete(long id){
		postRepository.delete(id);
	}
	
	public long count(){
		return postRepository.count();
	}
	
	public boolean exists(long id){
		return postRepository.exists(id);
	}
}
