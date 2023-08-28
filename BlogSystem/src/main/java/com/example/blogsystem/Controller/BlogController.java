package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiResponse;
import com.example.blogsystem.Model.Blog;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Service.BlogService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/getallblog")
    public ResponseEntity getAllBlogs(){

        return ResponseEntity.status(200).body(blogService.getAll());
    }

    @GetMapping("/get-my-blog")
    public ResponseEntity getMybloogs(@AuthenticationPrincipal User user){
        return ResponseEntity.status(200).body(blogService.getMyBlog(user.getId()));
    }

    @GetMapping("/get-blog-by-id/{blog_id}")
    public ResponseEntity getMyblogId(@AuthenticationPrincipal User user,@PathVariable Integer blog_id){
        return ResponseEntity.status(200).body(blogService.getBlogbyId(blog_id,user.getId()));
    }
    @GetMapping("/get-blog-by-title/{title}")
    public ResponseEntity getMyblogbytitle(@AuthenticationPrincipal User user,@PathVariable String title){
        return ResponseEntity.status(200).body(blogService.getBlogbytitle(title,user.getId()));
    }

    @PostMapping("/add-my-blog")
    public ResponseEntity add(@AuthenticationPrincipal User user, @RequestBody @Valid Blog blog){
        blogService.addBlog(user.getId(),blog);
        return ResponseEntity.status(200).body(new ApiResponse("blog added"));
    }

    @PutMapping("/update/{blog_id}")
    public ResponseEntity update(@AuthenticationPrincipal User user,@PathVariable Integer blog_id,@RequestBody @Valid Blog blog ){
        blogService.updateBlog(user.getId(),blog_id, blog);
        return ResponseEntity.status(200).body(new ApiResponse("blog updated"));
    }

    @DeleteMapping("/delete/{blog_id}")
    public ResponseEntity delete(@PathVariable Integer blog_id,@AuthenticationPrincipal User user){
        blogService.deleteBlog(user.getId(), blog_id);
        return ResponseEntity.status(200).body(new ApiResponse("blog deleted"));
    }



}
