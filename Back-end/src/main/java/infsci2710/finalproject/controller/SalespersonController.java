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

import infsci2710.finalproject.model.Salesperson;
import infsci2710.finalproject.service.SalespersonService;

@RestController
@RequestMapping("/api")
public class SalespersonController {
	
	@Autowired
	private SalespersonService salespersonService;
	
	@GetMapping("/salesperson")
	public List<Salesperson> getAll(){
		return salespersonService.getAll();
	}
	
	@GetMapping("/salesperson/{id}")
	public Salesperson getById(@PathVariable long id) {
		Salesperson salespersonObj= salespersonService.getById(id);
		if(salespersonObj==null) {
			throw new RuntimeException("Salesperson with id"+id+" is not found");
		}
		return salespersonObj;
	}
	
	@PostMapping("/salesperson")
	public Salesperson save(@RequestBody Salesperson salespersonObj) {
		salespersonService.save(salespersonObj);
		return salespersonObj;
	}
	
	@PutMapping("/salesperson")
	public Salesperson update(@RequestBody Salesperson salespersonObj) {
		salespersonService.save(salespersonObj);
		return salespersonObj;
	}
	
	@DeleteMapping("/salesperson/{id}")
	public String delete(@PathVariable long id) {
		salespersonService.delete(id);
		return "Salesperson has been deleted with id:"+id;
	}

}
