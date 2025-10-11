package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String home()
    {
        return "homePage";
    }

    @RequestMapping("/calculate")
    public String calculateAge(@RequestParam("year") int year,
                               @RequestParam("month") int month,
                               @RequestParam("day") int day,
                               Model model) {

        LocalDate birthDate;
        LocalDate today = LocalDate.now();

        try {
            birthDate = LocalDate.of(year, month, day);
        } catch (Exception e) {
            model.addAttribute("error", "❌ Invalid date entered.");
            return "resultPage";
        }

        if (birthDate.isAfter(today)) {
            model.addAttribute("error", "❌ The entered date is in the future.");
            return "resultPage";
        }

        Period diff = Period.between(birthDate, today);

        String result = String.format(
                "The difference between your birth date and today is %d years, %d months, and %d days.",
                diff.getYears(), diff.getMonths(), diff.getDays()
        );

        model.addAttribute("result", result);

        return "resultPage";
    }
}