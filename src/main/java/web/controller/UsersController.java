package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public String getInfo(ModelMap modelMap, Principal principal) {
        modelMap.addAttribute("userInfo", userService.findUserByLogin(principal.getName()));
        //System.out.println(userService.findUserByLogin(principal.getName())); эта строка приводит к StuckOverflowException
        return "users/info";
    }

}
