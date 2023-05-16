package com.example.sessionattribute.controller;

import com.example.sessionattribute.ds.Address;
import com.example.sessionattribute.ds.Department;
import com.example.sessionattribute.ds.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"employee", "department","address"})
public class EmployeeController {

    @GetMapping(value = {"/employee-form","/"})
    public String employeeForm(@ModelAttribute("employee")Employee  employee){
        return "employeeForm";
    }

    @PostMapping("/employee-form")
    public String processEmployee(@ModelAttribute("employee")Employee employee,
                                  BindingResult result){
        if(result.hasErrors()){
            return "employeeForm";
        }else{
            return "redirect:/department-form";
        }

    }

    @GetMapping("/department-form")
    public String departmentForm(@ModelAttribute("department")Department department){
        return "departmentForm";
    }

    @PostMapping("/department-form")
    public String processDepartment(@ModelAttribute("department")Department department
            ,BindingResult result){
        if(result.hasErrors()){
            return "departmentForm";
        }else{
            return "redirect:/address-form";
        }
    }

    @GetMapping("/address-form")
    public String addressForm(@ModelAttribute("address")Address address){
        return "addressForm";
    }

    @PostMapping("/address-form")
    public String processAllData(@ModelAttribute("employee")Employee employee,
                                 @ModelAttribute("department")Department department,
                                 @ModelAttribute("address")Address address){

        return "redirect:/success";

    }

    @GetMapping("/success")
    public String saveDate(Model model){
        model.addAttribute("msg","Successfully");
        return "success";
    }

    @ModelAttribute("employee")
    public Employee employee(){
        return new Employee();
    }

    @ModelAttribute("department")
    public Department department(){
        return new Department();
    }

    @ModelAttribute("address")
    public Address address(){
        return new Address();
    }

}
