package cs544.project.blog.repository;

import cs544.project.blog.domain.Like;
import cs544.project.blog.domain.Person;
import cs544.project.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    public List<Like> getLikeByPerson(Person person);
    public List<Like> getLikeByPost(Post post);
    public Like findDistinctByPersonAndAndPost(Person person, Post post);
}
