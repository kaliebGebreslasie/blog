package cs544.project.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import cs544.project.blog.service.CommentService;
import cs544.project.blog.service.PersonService;
import cs544.project.blog.service.PostService;
import cs544.project.blog.service.UserService;



@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	@Bean
	public PersonService pService(){
		return new PersonService();
	}
	@Bean
	public CommentService perService(){
		return new CommentService();
	}
	@Bean
	public PostService oService(){
		return new PostService();
	}
	
	@Bean
	public UserService uService(){
		return new UserService();
	}
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/blog");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("");
	    return driverManagerDataSource;
	}
	
	
}