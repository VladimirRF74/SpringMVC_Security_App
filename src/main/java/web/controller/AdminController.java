package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.services.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private final UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }
//ввывод всех пользователей
    @GetMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("userList", userService.getAllUsers());
        return "admin/index";
    }

    @GetMapping(value = "/add")
    public String newUser(@ModelAttribute("user") User user) {
        return "admin/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin/index";
    }

    @GetMapping(value = "/modify/{id}")
    public String modifyUser(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("message", userService.findUserById(id));
        return "admin/modify";
    }

    @PostMapping(value = "/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.findUserById(id));
        return "admin/edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin/index";
    }
}
