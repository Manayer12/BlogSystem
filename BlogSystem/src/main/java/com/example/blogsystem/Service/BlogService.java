package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Blog;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.AuthRepository;
import com.example.blogsystem.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final AuthRepository authRepository;
    private final BlogRepository blogRepository;

    public List<Blog> getAll(){

        return blogRepository.findAll();
    }
    public List<Blog> getMyBlog(Integer user_id){
        User user=authRepository.findUserById(user_id);
        return blogRepository.findAllByUser(user);
    }

    public Blog getBlogbyId(Integer blog_id,Integer user_id){
        User user=authRepository.findUserById(user_id);
        Blog blog=blogRepository.findBlogByIdAndUser(blog_id,user);
        return blog;
    }

    public Blog getBlogbytitle(String title,Integer user_id){
        User user=authRepository.findUserById(user_id);
        Blog blog=blogRepository.findBlogByTitleAndUser(title,user);
        return blog;
    }



    public void addBlog(Integer user_id,Blog blog){
        User user=authRepository.findUserById(user_id);
        blog.setUser(user);
        blogRepository.save(blog);
    }

    public void updateBlog(Integer user_id,Integer blog_id,Blog blog){
        User user=authRepository.findUserById(user_id);
        Blog oldBlog=blogRepository.findBlogById(blog_id);
        if(oldBlog==null){
            throw new ApiException("id not found");
        }
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());
        blogRepository.save(oldBlog);

    }

    public void deleteBlog(Integer blog_id,Integer user_id){
        User user=authRepository.findUserById(user_id);
        Blog oldBlog=blogRepository.findBlogById(blog_id);
        if(oldBlog==null){
            throw new ApiException("id not found");
        }

        blogRepository.deleteById(blog_id);
    }



}
