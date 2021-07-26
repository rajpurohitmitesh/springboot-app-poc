package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee emp) {
		repo.save(emp);
		return "addEmployee.jsp";
	}
	
	@RequestMapping("/searchEmployee")
	public ModelAndView getEmployee(@RequestParam int eid) {
		
		ModelAndView mv = new ModelAndView("showData.jsp");
		Employee emp = repo.findById(eid).orElse(new Employee());
		mv.addObject(emp);
		System.out.println("Hello......"+emp);
		return mv;
	}


}
