package com.csi.controller;

import com.csi.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @GetMapping("/sayhello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("HELLO WORLD");
    }

    @GetMapping("/getalldata")
    public List<Employee> getAllData(){
        return Stream.of(new Employee(1, "RAM", 25000),
                new Employee(2, "KOMAL", 65000),
                new Employee(3, "SHRI", 90000),
                new Employee(4, "PAYAL", 50000)).collect(Collectors.toList());
    }

    @GetMapping("/filterdatabysalary/{salary}")
    public List<Employee> filterDataBySalary(@PathVariable double salary){
        return getAllData().stream().filter(emp -> emp.getSalary() > salary).toList();
    }

}
