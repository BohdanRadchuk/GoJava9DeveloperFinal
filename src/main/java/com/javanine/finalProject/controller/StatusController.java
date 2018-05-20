package com.javanine.finalProject.controller;


import com.javanine.finalProject.model.Product;
import com.javanine.finalProject.model.Status;
import com.javanine.finalProject.model.enums.EmployeeStatus;
import com.javanine.finalProject.service.StatusService;
import com.javanine.finalProject.service.impl.StatusServiceImpl;
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
@RequestMapping("/status")
@Api(value = "statuses", description = "Operations with statuses")
public class StatusController {

    @Autowired
    private StatusServiceImpl statusService;


    @ApiOperation(value = "View a list of available products", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public List<Status> list(Model model) {
        List<Status> statusList = statusService.findAll();
        System.out.println(statusList);

        return statusList;
    }


    @ApiOperation(value = "Search a product with an ID", response = Status.class)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public Status showProduct(@PathVariable Long id, Model model) {

        System.out.println(id);

        Status status = statusService.findById(id);
        System.out.println(status);
        return status;
    }

    @ApiOperation(value = "Search a product with an ID", response = Status.class)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Status addProduct(@PathVariable Long id, Model model) {
        Status status = statusService.findById(id);
        return status;
    }

    @ApiOperation(value = "Add a status")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Status status) {
        System.out.println(status);
        statusService.save(status);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }


  /*  @ApiOperation(value = "Delete a product")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE *//*path = "{id}", method = RequestMethod.DELETE*//*)
    public ResponseEntity delete(@PathVariable Long id, Model model) {
        System.out.println(id);

        //statusService.deleteById(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);

    }
*/

    @ApiOperation(value = "Delete a product")
    @RequestMapping(value = "/deletee/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(Long id, Model model) {
        System.out.println(id);
        statusService.deleteById(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }



   /* @ApiOperation(value = "Update a product")
        @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
        public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Status status){
         Status status = new Status();
         status.setId(4l);
         status.setStatusName(EmployeeStatus.HOLIDAY);

         statusServiceImpl.save(status);

            Product storedProduct = productService.getProductById(id);
            storedProduct.setDescription(product.getDescription());
            storedProduct.setImageUrl(product.getImageUrl());
            storedProduct.setPrice(product.getPrice());
            productService.saveProduct(storedProduct);
            return new ResponseEntity("Product updated successfully", HttpStatus.OK);
        }*/

}


