package com.javanine.finalProject.controller;

import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping("/list-departments")
    public String findAll(Model model){
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        //model.addAttribute("loggedUser", MainController.getPrincipal());
        return "department/list_departments";
    }
}
