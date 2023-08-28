package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Blog;
import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Blog findBlogById(Integer id);
    Blog findBlogByIdAndUser(Integer user_id,User user);
    List<Blog> findAllByUser(User user);

    Blog findBlogByTitleAndUser( String title,User user);
    //Blog findBlogByTitle(String title);


}
