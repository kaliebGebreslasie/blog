package cs544.project.blog.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.Valid;

import org.hibernate.validator.constraints.SafeHtml;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Lob
	
	private String content;
	@Temporal(TemporalType.DATE)
	private Date datecreated;
	@Temporal(TemporalType.DATE)
	private Date dateupdated;
	@ManyToOne
	@JsonIgnore
	
	private Post post;
	@JsonIgnore
	@ManyToOne
	
	private Person person;
	
	public Comment() {
	}

	public Comment( String content, Date datecreated, Date dateupdated, Post post, Person person) {
		super();
		this.content = content;
		this.datecreated = datecreated;
		this.dateupdated = dateupdated;
		this.post=post;
		this.person = person;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	public Date getDateupdated() {
		return dateupdated;
	}

	public void setDateupdated(Date dateupdated) {
		this.dateupdated = dateupdated;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
