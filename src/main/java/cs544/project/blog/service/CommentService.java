package cs544.project.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.blog.domain.Comment;
import cs544.project.blog.repository.CommentRepository;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment getById(long id){
		return commentRepository.findOne(id);
	}
	
	public List<Comment> getAll(){
		return commentRepository.findAll();
	}
	
	public Comment save(Comment comment){
		return commentRepository.save(comment);
	}
	
	public void delete(long id){
		commentRepository.delete(id);
	}
	
	public long count(){
		return commentRepository.count();
	}
	
	public boolean exists(long id){
		return commentRepository.exists(id);
	}
}
