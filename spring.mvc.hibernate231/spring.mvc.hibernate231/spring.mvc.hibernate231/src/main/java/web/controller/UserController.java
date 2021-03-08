package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.RoleService;
import web.service.UserService;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping()
    public String showUsersForUser(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUser", allUsers);

        return "user/user-list";
    }
}
