package com.app.demo.controller;

import com.app.demo.model.UserRegistrationDto;
import com.app.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showForm(Model model) {

        model.addAttribute("user", new UserRegistrationDto());

        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(
            @Valid @ModelAttribute("user") UserRegistrationDto dto,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "register";
        }

        try {
            userService.registerUser(dto);
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "register";
        }

        redirectAttributes.addFlashAttribute("registered", true);

        return "redirect:/login";
    }
}