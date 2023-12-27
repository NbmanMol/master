package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user2s")
    public String printUserTable(Model model) {
        model.addAttribute("ListUser", userService.getUserList());
        return "admin/users";
    }

    @GetMapping("/new")
    public String returnCreateUserPage(Model model) {
        model.addAttribute("user", new User());
        return "admin/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/update")
    public String returnUpdateUserPage(Model model, @RequestParam Integer id) {
        model.addAttribute("user", userService.getUserForId(id));
        return "admin/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User updatedUser) {
        userService.updateUser(updatedUser);
        return "redirect:/admin/users";
    }

    @GetMapping("/delete")
    public String removeUser(@RequestParam Integer id) {
        userService.deleteUser(userService.getUserForId(id));
        return "redirect:/admin/users";
    }

}