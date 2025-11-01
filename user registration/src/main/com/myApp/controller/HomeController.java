package main.com.myApp.controller;

import main.com.myApp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showUserForm(Model model)
    {
        model.addAttribute("user", new User());

        return "user-form";
    }

    @RequestMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user, Model model) {

        model.addAttribute("userResult", user);

        return "register-success";
    }
}


