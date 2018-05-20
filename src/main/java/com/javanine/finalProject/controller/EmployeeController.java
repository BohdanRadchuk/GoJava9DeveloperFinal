package com.javanine.finalProject.controller;

import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.model.Status;
import com.javanine.finalProject.service.impl.EmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Api(value = "employees", description = "Operations with employees")
public class EmployeeController {


        @Autowired
        private EmployeeServiceImpl employeeService;


        @ApiOperation(value = "View a list of available products", response = List.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Successfully retrieved list"),
                @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
        }
        )
        @GetMapping(value = "/list", produces = "application/json")
        public List<Employee> list(Model model) {
            List<Employee> statusList = employeeService.findAll();
            System.out.println(statusList);

            return statusList;
        }


        @ApiOperation(value = "Search a product with an ID", response = Employee.class)
        @GetMapping(value = "/show/{id}", produces = "application/json")
        public Employee showEmployee(@PathVariable Long id, Model model) {
            System.out.println(id);
            Employee employee = employeeService.findById(id);
            System.out.println(employee);
            return employee;
        }

        @ApiOperation(value = "Search a product with an ID", response = Employee.class)
        @PutMapping(value = "/show/{id}", produces = "application/json")
        public Employee addEmployee(@PathVariable Long id, Model model) {
            Employee employee = employeeService.findById(id);
            return employee;
        }

        @ApiOperation(value = "Add a status")
        @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
        public ResponseEntity saveProduct(@RequestBody Employee employee) {
            System.out.println(employee);
            employeeService.save(employee);
            return new ResponseEntity("Product saved successfully", HttpStatus.OK);
        }


  /*  @ApiOperation(value = "Delete a product")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE *//*path = "{id}", method = RequestMethod.DELETE*//*)
    public ResponseEntity delete(@PathVariable Long id, Model model) {
        System.out.println(id);

        //employeeService.deleteById(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);

    }
*/

        @ApiOperation(value = "Delete a product")
        @DeleteMapping(value = "/deletee/{id}", produces = "application/json")
        public ResponseEntity delete(Long id, Model model) {
            System.out.println(id);
            employeeService.deleteById(id);
            return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
        }

}
