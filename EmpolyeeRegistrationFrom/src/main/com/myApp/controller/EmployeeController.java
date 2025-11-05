package main.com.myApp.controller;

import main.com.myApp.model.Employee;
import main.com.myApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @RequestMapping("/")
    public String showForm(Model model) {

        model.addAttribute("employee", new Employee());

        return "registrationForm";
    }

    @RequestMapping("/registerEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            return "registrationForm";
        }

        if (!employee.getPassword().equals(employee.getConfirmPassword())) {

            result.rejectValue("confirmPassword", "error.employee", "Passwords do not match");

            return "registrationForm";
        }

        employeeService.saveEmplyee(employee);

        return "registrationSuccessForm";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmer);
    }
}