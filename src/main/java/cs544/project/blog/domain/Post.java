package cs544.project.blog.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	@Lob
	private String content;
	@Temporal(TemporalType.DATE)
	private Date datecreated;
	@Temporal(TemporalType.DATE)
	private Date dateupdated;
	private String summary;
	
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL)
	private List<Comment> comments=new ArrayList<>();
	@ManyToOne
	@JsonIgnore
	private Person person;
	
	public Post() {
	}

	public Post(long id, String title, String content, Date datecreated, Date dateupdated,String summary,List<Comment> comments,
			Person person) {
		super();
		
		this.title = title;
		this.content = content;
		this.datecreated = datecreated;
		this.dateupdated = dateupdated;
		this.summary=summary;
		this.comments = comments;
		this.person = person;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void addComment(Comment comment){
		this.comments.add(comment);
	}
}
