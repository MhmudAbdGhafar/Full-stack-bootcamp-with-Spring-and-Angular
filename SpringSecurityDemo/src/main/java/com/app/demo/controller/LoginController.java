package com.app.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showHomePage() {
        return "homePage";
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        return "adminPage";
    }

    @GetMapping("/system")
    public String showSystemPage() {
        return "systemPage";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "loginPage";
    }

    @GetMapping("/accessDenied")
    public String showAccessDeniedPage() {
        return "accessDenied";
    }

}
