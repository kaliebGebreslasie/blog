package cs544.project.blog.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String email;
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Comment> comments=new ArrayList<>();
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	
	private List<Post> posts=new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	
	private User user;
	
	public Person() {
	}

	public Person( String name, String email, List<Comment> comments, List<Post> posts,User user) {
		super();

		this.name = name;
		this.email = email;
		this.comments = comments;
		this.posts = posts;
	this.user=user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public void addPost(Post post){
		this.posts.add(post);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
