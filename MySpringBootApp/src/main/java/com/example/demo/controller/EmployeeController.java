package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	/*
	 * @PostMapping(path="/addEmployee1", consumes= {"application/json"}) public
	 * Employee addEmployee1(@RequestBody Employee emp) { repo.save(emp); return
	 * emp; }
	 */

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
	@ResponseBody
	public ModelAndView getAllSavedEmployee() throws ParseException {
		ModelAndView mv = new ModelAndView("getAllEmployee.jsp");
		List<Employee> resbody = repo.findAll();
		mv.addObject("e1", resbody);
		return mv;
	}

	@RequestMapping("/editEmployeeView")
	public ModelAndView editEmployeeView(@RequestParam int eid) {
		ModelAndView mv = new ModelAndView("editData.jsp");
		Employee emp = repo.findById(eid).orElse(new Employee());
		mv.addObject("test", emp);
		return mv;
	}

	@RequestMapping("/updateEmployee")
	public ModelAndView updateEmployee(@RequestParam int eid, Employee emp) {
		ModelAndView mv = new ModelAndView("editDataSuccess.jsp");
		emp.setEid(eid);
		repo.save(emp);
		mv.addObject("test", emp);
		return mv;
	}
	
	

	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam int eid) {
		ModelAndView mv = new ModelAndView("deleteDataSuccess.jsp");
		Employee emp = repo.getOne(eid);
		repo.delete(emp);
		mv.addObject("test", emp);
		return mv;
	}

}
