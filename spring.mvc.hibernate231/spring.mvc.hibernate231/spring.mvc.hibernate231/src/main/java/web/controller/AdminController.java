package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.entity.Role;
import web.entity.User;
import web.service.RoleService;
import web.service.UserService;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showUsersForAdmin(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "admin/user-list";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        Set<Role> roleSet = roleService.findAllRoles();
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleSet);
        return "admin/user-creat";
    }

    @PostMapping(value = "/addNewUser")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }


    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "admin/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.update(user);
        return "redirect:/admin";
    }
}
