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

import infsci2710.finalproject.model.Customer;
import infsci2710.finalproject.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> getAll() {
		return customerService.getAll();
	}
	
	@GetMapping("/customer/{id}")
	public Customer getById(@PathVariable long id) {
		Customer customerObj= customerService.getById(id);
		if(customerObj==null) {
			throw new RuntimeException("Customer with id"+id+" is not found");
		}
		return customerObj;
	}
	
	@PostMapping("/customer")
	public Customer save(@RequestBody Customer customerObj) {
		customerService.save(customerObj);
		return customerObj;
	}
	
	@PutMapping("/customer")
	public Customer update(@RequestBody Customer customerObj) {
		customerService.save(customerObj);
		return customerObj;
	}
	
	@DeleteMapping("/customer/{id}")
	public String delete(@PathVariable long id) {
		customerService.delete(id);
		return "Customer has been deleted with id:"+id;
	}

}
