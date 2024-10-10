package com.app.micro.controller;

import com.app.micro.entity.User;
import com.app.micro.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, Model model) {
        userService.saveUser(user);
        model.addAttribute("message", "User registered successfully");
        return "register";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);
        if (user != null && new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            model.addAttribute("message", "Login successful");
            return "userPage";
        }
        model.addAttribute("message", "Invalid username or password");
        return "login";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registerPage")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/userPage")
    public String userPage() {
        return "userPage";
    }
}