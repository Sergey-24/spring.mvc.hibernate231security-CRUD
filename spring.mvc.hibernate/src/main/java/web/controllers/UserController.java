package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;

import java.util.List;

@Controller
@SessionAttributes("user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model){

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUser", allUsers);

        return "user-list";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "user-creat";
    }

    @PostMapping(value = "/addNewUser")
    public String saveUser(User user){
        userService.saveUser(user);
        return "redirect:/";
    }


}
