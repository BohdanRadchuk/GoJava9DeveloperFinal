package com.javanine.finalProject.rest;


import com.javanine.finalProject.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;
}