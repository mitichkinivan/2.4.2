package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserServiceImpl userService;

    @Autowired
    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }

    public AdminController() {
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("user", userService.allUsers());
        return "admin/allUsers";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "admin/newUser";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/userById")
    public String userById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.userById(id));
        return "admin/userById";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("{id}")
    public String delete(@ModelAttribute("user") User user,
                         @PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}