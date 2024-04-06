package com.demo.crud.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crud.Service.EmpServie;
import com.demo.crud.entity.Employee;

import jakarta.websocket.server.PathParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class EmpController {

    private static final int Employee = 0;
    @Autowired
    private EmpServie empServie;
    //Inset
    @PostMapping("/add")
     public ResponseEntity<String>  addUSer(@RequestBody Employee emp)
    {
        empServie.saveStudent(emp);
       return  ResponseEntity.status(HttpStatus.OK).body("data addes successfully");
        
    }
    //getall
    @GetMapping("/getall")
    public List<Employee> getAllUser() {
        return empServie.getUser();
    }
    //get by id
    @GetMapping("/getbyid/{id}")
    public Employee getById(@PathVariable("id") Long id)
    {
        return empServie.getbyid(id);
    }
    //update
    @PutMapping("/updateemp/{id}")
    public ResponseEntity<String> updateemp(@RequestBody Employee emp,@PathVariable("id") Long id)
    {
        try {
            empServie.saveStudent(emp);
            return  ResponseEntity.status(HttpStatus.OK).body("data updated successfully");

        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Issue in updating");

        }
         
    }
    //delete
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<String>  deleteuser(@PathVariable("id") Long id)
    {
        try {
            empServie.deleteuser(id);
            return  ResponseEntity.status(HttpStatus.OK).body("data deleted successfully");

        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Issue in deleting");
        }
    }
    //delete all data
    
    @DeleteMapping("/deletealluser")
    public ResponseEntity<String> deleteAllUser() {
        try {
            empServie.deletealluser();
            return  ResponseEntity.status(HttpStatus.OK).body("All data deleted successfully");
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Issue in deleting");
        }
    }
   
    
}
