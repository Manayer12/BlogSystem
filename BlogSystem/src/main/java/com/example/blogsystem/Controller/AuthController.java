package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.User;
import com.example.blogsystem.Service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/rigster")
    public ResponseEntity register (@RequestBody @Valid User user){
        authService.register(user);
        return ResponseEntity.status(200).body("User Rigsterd");

    }

    @GetMapping("/logout")
    public ResponseEntity logout(){

        return ResponseEntity.status(200).body("loged out");
    }

}
