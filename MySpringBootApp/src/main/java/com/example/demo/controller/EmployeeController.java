package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		return "employee_saved.jsp";
	}

	@RequestMapping("/searchEmployee")
	public ModelAndView getEmployeeByID(@RequestParam int eid) {
		ModelAndView mv = new ModelAndView("showData.jsp");
		Employee emp = repo.findById(eid).orElse(new Employee());
		mv.addObject("test", emp);
		return mv;
	}
	
	@RequestMapping("/getAllEmployee")
	public ModelAndView getAllSavedEmployee() {
		ModelAndView mv = new ModelAndView("getAllEmployee.jsp");
		List li=new ArrayList();
		li.add(repo.findAll());
		mv.addObject("test", li);
		System.out.println("hello"+mv);
		return mv;
	}

}
