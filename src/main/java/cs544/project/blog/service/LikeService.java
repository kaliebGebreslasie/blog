package cs544.project.blog.service;

import cs544.project.blog.domain.Like;
import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.Post;
import cs544.project.blog.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Like getById(long id) { return likeRepository.findOne(id); }

    public List<Like> getAll() { return likeRepository.findAll(); }

    public Like save(Like like) { return likeRepository.save(like); }

    public void delete(long id) { likeRepository.delete(id); }

    public long count() { return likeRepository.count(); }

    public boolean exists(long id) { return likeRepository.exists(id); }

    public List<Like> getByPerson(Person person) {return likeRepository.getLikeByPerson(person); }

    public List<Like> getByPost(Post post) { return likeRepository.getLikeByPost(post); }

    public Like getByPersonPost(Person person, Post post){ return likeRepository.findDistinctByPersonAndAndPost(person, post); }
}
