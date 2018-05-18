package com.javanine.finalProject.controller;

import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.model.Position;
import com.javanine.finalProject.service.impl.DepartmentServiceImpl;
import com.javanine.finalProject.service.impl.PositionServiceImpl;
import com.javanine.finalProject.validator.DepartmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private DepartmentValidator departmentValidator;

    @Autowired
    private PositionServiceImpl positionService;

    @GetMapping("/list-departments")
    public String getAll(Model model){
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        //model.addAttribute("loggedUser", );
        return "department/list_departments";
    }

    @GetMapping("/department-positions-{id}")
    public String getDepartmentPositions(@PathVariable String id, Model model){
        Department department = departmentService.findById(Long.parseLong(id));
        return addDataToDepartmentForm(model, department, false,"department/department_positions");
    }

    @GetMapping("/add-position-to-department-{id}")
    public String addPosition(@PathVariable String id, Model model){
        Department department = departmentService.findById(Long.parseLong(id));
        Position position = new Position();
        position.setId(new Random().nextLong());
        position.setDepartment(department);
        model.addAttribute("position", position);
        //model.addAttribute("loggedUser", );
        return "department/add_position";
    }

    @PostMapping("/add-position-to-department")
    public String savePosition(@ModelAttribute("position") @Valid Position position,
                               BindingResult result, Model model){
        // validation
        positionService.save(position);
        return getDepartmentPositions(position.getDepartment().getId().toString(), model);
    }

    @GetMapping("/delete-department-position-{departmentId}/{positionId}")
    public String deletePosition(@PathVariable String departmentId, @PathVariable String positionId, Model model){
        positionService.deleteById(Long.parseLong(positionId));
        return getDepartmentPositions(departmentId, model);
    }

    @GetMapping("/department-employees-{id}")
    public String getDepartmentEmployees(@PathVariable String id, Model model){
        Department department = departmentService.findById(Long.parseLong(id));
        return addDataToDepartmentForm(model, department, false, "department/department_employees");
    }

    //TODO
    @GetMapping("/add-employee-to-department-{id}")
    public String addEmployee(@PathVariable String id, Model model){
        Department department = departmentService.findById(Long.parseLong(id));
        return null;
    }

    //TODO
    @PostMapping("/add-employee-to-department")
    public String saveEmployee(@PathVariable String id, Model model){
        return null;
    }

    //TODO
    @GetMapping("/delete-department-employee-{departmentId}/{employeeId}")
    public String deleteEmployee(@PathVariable String departmentId, @PathVariable String employeeId, Model model){
        return getDepartmentEmployees(departmentId, model);
    }

    @GetMapping("/new-department")
    public String addDepartment(Model model){
        Department department = new Department();
        department.setId(new Random().nextLong());
        return addDataToDepartmentForm(model, department, false, "department/department");
    }

    @PostMapping("/new-department")
    public String saveDepartment(@ModelAttribute("department") @Valid Department department,
                                 BindingResult result, Model model){
        return saveDepartment(department, result, model, false);
    }

    @GetMapping("/edit-department-{id}")
    private String editDepartment(@PathVariable String id, Model model) {
        Department department = departmentService.findById(Long.parseLong(id));
        return addDataToDepartmentForm(model, department, false, "department/department");
    }

    @PostMapping("/edit-department-{id}")
    private String saveEdit(@ModelAttribute("department") @Valid Department department,
                            BindingResult result, Model model) {
        return saveDepartment(department, result, model, false);
    }

    @GetMapping("/delete-department-{id}")
    public String delete(@PathVariable String id) {
        departmentService.deleteById(Long.parseLong(id));
        return "redirect:/list-departments";
    }

    private String saveDepartment(@ModelAttribute("department") @Valid Department department,
                                  BindingResult result, Model model, boolean edit){
        departmentValidator.validate(department, result);
        if (!edit) {
            departmentValidator.isNameDuplicate(department, result);
        }
        if (result.hasErrors()) {
            return addDataToDepartmentForm(model, department, false, "department/department");
        }
        departmentService.save(department);
        return getAll(model);
    }

    private String addDataToDepartmentForm(Model model, Department department, boolean edit ,String pageName){
        model.addAttribute("department", department);
        model.addAttribute("edit", edit);
        //model.addAttribute("loggedUser", );
        return pageName;
    }
}
