package com.example.demo.dao;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;

@Component
public class UserServices {
     
	@Autowired
     EmployeeRepo repo;
     
    public List<Employee> listAll() {
        return repo.findAll();
    }
    	
     

}
