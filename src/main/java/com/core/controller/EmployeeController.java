package com.core.controller;


import com.core.dao.EmployeeDao;
import com.core.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody Employee employee){

        employeeDao.signUp(employee);
        return ResponseEntity.ok("data saved");
    }
    @GetMapping("/getAllData")
    public ResponseEntity<List<Employee>> getAll(){

        return ResponseEntity.ok(employeeDao.getData());
    }

    @PutMapping("/updateData")
    public ResponseEntity<Employee> updateData(@RequestBody Employee employee) {

        return ResponseEntity.ok(employeeDao.updateData(employee));
    }
    @DeleteMapping("/deleteDataById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){

        employeeDao.deleteDataById(id);
        return ResponseEntity.ok("");
    }
}
