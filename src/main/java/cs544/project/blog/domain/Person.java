package cs544.project.blog.domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Comment> comments;
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Post> posts;
	
	public Person() {
	}

	public Person(long id, String name, String email, List<Comment> comments, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.comments = comments;
		this.posts = posts;
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
}
