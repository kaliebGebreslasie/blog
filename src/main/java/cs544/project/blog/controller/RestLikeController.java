package cs544.project.blog.controller;

import cs544.project.blog.domain.Like;
import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.Post;
import cs544.project.blog.service.LikeService;
import cs544.project.blog.service.PersonService;
import cs544.project.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/like")
public class RestLikeController {
    @Autowired
    private LikeService likeService;
    @Autowired
    private PersonService personService;
    @Autowired
    private PostService postService;

    @PostMapping(value="/{username}/{postid}")
    public Like saveLike(@RequestBody Like like, @PathVariable String username, @PathVariable long postid){
        Person person = personService.getByName(username);
        Post post = postService.getById(postid);
        like.setId(0);
        like.setPost(post);
        like.setPerson(person);
        return likeService.save(like);
    }

    @DeleteMapping(value="/{username}/{postid}")
    public void unLike(@PathVariable String username, @PathVariable long postid){
        Person person = personService.getByName(username);
        Post post = postService.getById(postid);
        Like like = likeService.getByPersonPost(person, post);
        likeService.delete(like.getId());
    }

    @GetMapping("/post/{id}")
    public List<Like> findByPost(@PathVariable long id){
        Post post = postService.getById(id);
        return likeService.getByPost(post);
    }

    @GetMapping("/person/{id}")
    public List<Like> findByPerson(@PathVariable long id){
        Person person = personService.getById(id);
        return likeService.getByPerson(person);
    }

}
