package com.javanine.finalProject.validator;

import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DepartmentValidator implements Validator {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Department.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }

    public void isNameDuplicate(Department department, Errors errors) {
        if (departmentService.findByName(department.getName()) != null) {
            errors.rejectValue("name", "Duplicate.department.name");
        }
    }
}
