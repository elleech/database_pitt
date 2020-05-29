package infsci2710.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import infsci2710.finalproject.model.Employee;
import infsci2710.finalproject.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getById(@PathVariable long id) {
		Employee employeeObj= employeeService.getById(id);
		if(employeeObj==null) {
			throw new RuntimeException("Employee with id"+id+" is not found");
		}
		return employeeObj;
	}
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employeeObj) {
		employeeService.save(employeeObj);
		return employeeObj;
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employeeObj) {
		employeeService.save(employeeObj);
		return employeeObj;
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable long id) {
		employeeService.delete(id);
		return "Employee has been deleted with id:"+id;
	}

}
