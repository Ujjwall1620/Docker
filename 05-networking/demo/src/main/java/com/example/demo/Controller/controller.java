package com.example.demo.Controller;

import com.example.demo.Entity.Message;
import com.example.demo.Repositories.repo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class controller {

    private final repo repo;

    public controller(repo repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("messages", repo.findAll());
        model.addAttribute("message", new Message());
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Message message) {
        repo.save(message);
        return "redirect:/";
    }
}