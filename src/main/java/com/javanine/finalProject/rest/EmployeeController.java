package com.javanine.finalProject.rest;

import com.javanine.finalProject.dto.EmployeeCreateDTO;
import com.javanine.finalProject.dto.EmployeeReadDTO;
import com.javanine.finalProject.dto.EmployeeUpdateDTO;
import com.javanine.finalProject.mapper.DtoMapper;
import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.model.User;
import com.javanine.finalProject.service.EmployeeService;
import com.javanine.finalProject.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value="employee", description="Operations pertaining to employee")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Wrong arguments"),
        @ApiResponse(code = 401, message = "You are not authorized to do this action"),
})
public class EmployeeController {

    @Autowired
    EmployeeService employeesService;

    @Autowired
    UserService userService;

    @Autowired
    private DtoMapper mapper;

 /*   @Autowired
    EmailService emailService;*/

//-------------------------------- get ----------------------------------------

    @ApiOperation(value = "Search an employee by ID", response = EmployeeReadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved employee"),
            @ApiResponse(code = 403, message = "Accessing the employee by id you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found")
    })
    @Secured({"ROLE_ADMIN", "ROLE_MODERATOR", "ROLE_USER"})
    @GetMapping(value = "/{employeeId}")
    public EmployeeReadDTO getEmployee(@ApiParam(value = "id of Employee", required = true) @PathVariable("employeeId") Long employeeId,
                                                       HttpServletRequest request) {
        if (request.isUserInRole("ROLE_USER")) {
        //    if (userService.checkLoginUserHavePetitionForThisInfo(employeeId, request)) {
                throw new AccessDeniedException("You don't have permit to get iformation about employee with id=" + employeeId);
       //     }
        }
        Employee employee = employeesService.findById(employeeId);
        if (employee == null) {
            String msg = String.format("There is no employee with id: %d", employeeId);
            throw new EntityNotFoundException(msg);
        }
        return mapper.simpleFieldMap(employee, EmployeeReadDTO.class);
    }

//--------------------------- delete ----------------------------------
    @ApiOperation(value = "Delete employee by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee successfully deleted"),
            @ApiResponse(code = 403, message = "Accessing deletion the employee you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found")
    })
    @Secured({"ROLE_ADMIN", "ROLE_MODERATOR"})
    @DeleteMapping(value = "/{employeeId}")
    public ResponseEntity deleteEmployee(@ApiParam(value = "id of Employee", required = true) @PathVariable("employeeId") Long employeeId) {
        employeesService.deleteById(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

//---------------------------edit ----------------------------------------------------
    @ApiOperation(value = "Update employee by ID", response = EmployeeReadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee successfully updated"),
            @ApiResponse(code = 403, message = "Accessing updating the employee you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found")
    })
    @Secured({"ROLE_ADMIN", "ROLE_MODERATOR"})
    @PostMapping(value = "/{employeeId}")
    public ResponseEntity editEmployee(@ApiParam(value = "id of Employee", required = true) @PathVariable("employeeId") Long employeeId,
                                       @ApiParam(value = "json body of Employee", required = true) @NotNull @RequestBody @Valid EmployeeUpdateDTO dto) {

        if (employeesService.findById(employeeId)==null) {
            String msg = String.format("There is no employee with id: %d", employeeId);
            throw new EntityNotFoundException(msg);
        }
        Employee employee = mapper.map(dto, Employee.class);
        employee.setId(employeeId);
        employeesService.save(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

////------------------------------------- getAll --------------------------------------------------------------
    @ApiOperation(value = "View a list of all employees", response = EmployeeReadDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee successfully shows"),
            @ApiResponse(code = 403, message = "Accessing updating the employee you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found")
    })
    @Secured({"ROLE_ADMIN", "ROLE_MODERATOR"})
    @GetMapping(value = "/getAll")
    public List<EmployeeReadDTO> getAllEmployees() {
        List<Employee> employee = employeesService.findAll();
        if (employee.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return mapper.listSimpleFieldMap(employee, EmployeeReadDTO.class);

    }

////-------------------------------add --------------------------------------------------------
    @ApiOperation(value = "Create employee", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Employee successfully created"),
            @ApiResponse(code = 403, message = "Accessing creating the employee you were trying to reach is forbidden")
    })
    @Secured({"ROLE_ADMIN", "ROLE_MODERATOR"})
    @PostMapping(value = "/add")
    public ResponseEntity saveEmployee(
            @ApiParam(value = "json body of Employee", required = true) @RequestBody @Valid EmployeeCreateDTO dto,
            HttpServletRequest request) {

        Employee employee = mapper.map(dto, Employee.class);
        System.out.println(dto.getEmail());
        User user = userService.findByEmail(dto.getEmail());
        System.out.println(user);
        /*user.setEmail(dto.getEmail());*/
        employee.setUser(user);
        employeesService.save(employee);

        sendWelcomeLetter(user.getEmail(),request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
////-----------------------------------------------------------------------------------------

    private void sendWelcomeLetter(String email,HttpServletRequest request) {
        String domain=request.getRequestURL().toString();
        String url = domain.substring(0,domain.indexOf("api")+3);
      /*  LettersExample lettersExample = new LettersExample();
        emailService.sendEmail(email, "welcome at HRManagement",lettersExample.createWelcomeMessage(url));*/
    }


}
