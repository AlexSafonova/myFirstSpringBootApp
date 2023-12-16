package alexsafonova.myFirstSpringBootApp.controller;

import alexsafonova.myFirstSpringBootApp.model.User;
import alexsafonova.myFirstSpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller

public class UsersController {
    private final UserService userService;
    @Autowired

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @PostMapping(value = "/add")
    public String addUser(@RequestParam String name, @RequestParam String surname) {
        User user = new User(name, surname);
        userService.addUser(user);
        return "redirect:/";
    }
    @PostMapping(value = "/update")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String surname) {
        User user = new User(name, surname);
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/";
    }
    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


}
