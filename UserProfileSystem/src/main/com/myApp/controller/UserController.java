package main.com.myApp.controller;

import main.com.myApp.mode.User;
import main.com.myApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showRegistrationForm() {

        return "registerHomePage";
    }

    @RequestMapping("/register")
    public String registerUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastname,
            @RequestParam("email" ) String email,
            @RequestParam("dateOfBirth") LocalDate dateOfBirth,
            @RequestParam("city")  String city,
            Model model)
    {

        userService.save(new User(firstName, lastname, email, dateOfBirth, city));

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastname);
        model.addAttribute("email", email);
        model.addAttribute("dateOfBirth", dateOfBirth);
        model.addAttribute("city", city);

        return "registerPage";
    }

}