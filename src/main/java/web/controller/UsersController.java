package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDao;

import java.security.Principal;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    private final UserDao userDao;

    public UsersController(UserDao userDaoImp) {
        this.userDao = userDaoImp;
    }

    @GetMapping("/info")
    public String getInfo(ModelMap modelMap, Principal principal) {
        modelMap.addAttribute("messages", userDao.findUserByLogin(principal.getName()));
        return "users/info";
    }

}
