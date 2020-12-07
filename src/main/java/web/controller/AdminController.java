package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private final UserDao userDao;
    @Autowired
    public AdminController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("message", userDao.getAllUsers());
        modelMap.addAttribute("messages", userDao.findUserByLogin("admin"));
        return "admin/index";
    }

    @GetMapping(value = "/add")
    public String newUser(@ModelAttribute("user") User user) {
        return "admin/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("user") User user) {
        userDao.addUser(user);
        return "redirect:/admin/index";
    }

    @GetMapping(value = "/modify/{id}")
    public String modifyUser(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("message", userDao.findUserId(id));
        return "admin/modify";
    }

    @PostMapping(value = "/{id}")
    public String delete(@PathVariable("id") Long id) {
        userDao.deleteUser(id);
        return "redirect:/admin/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userDao.findUserId(id));
        return "admin/edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userDao.updateUser(id, user);
        return "redirect:/admin/index";
    }
}
