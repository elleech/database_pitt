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

import infsci2710.finalproject.model.Cases;
import infsci2710.finalproject.service.CasesService;



@RestController
@RequestMapping("/api")
public class CasesController {
	
	@Autowired
	private CasesService casesService;
	
	@GetMapping("/cases")
	public List<Cases> getAll(){
		return casesService.getAll();
	}
	
	@GetMapping("/cases/{id}")
	public Cases getById(@PathVariable long id) {
		Cases casesObj= casesService.getById(id);
		if(casesObj==null) {
			throw new RuntimeException("Cases with id"+id+" is not found");
		}
		return casesObj;
	}
	
	@GetMapping("/cases/employee/{employeeId}")
	public List<Cases> getByEmployee(@PathVariable long employeeId){
		return casesService.getByEmployee(employeeId);
	}
	
	//<add>
	@GetMapping("/cases/product/{productId}")
	public List<Cases> getByProudct(@PathVariable long productId){
		return casesService.getByProduct(productId);
	}
	
	//<add>
	@GetMapping("/cases/customer/{customerId}")
	public List<Cases> getByCustomer(@PathVariable long customerId){
		return casesService.getByCustomer(customerId);
	}
	
	//<add>
	@GetMapping("/cases/customer/company/{companyname}")
	public List<Cases> getByCustomerCompany(@PathVariable String companyname){
		return casesService.getByCustomerCompany(companyname);
	}
	
	@GetMapping("/cases/open")
	public List<Cases> getOpen(){
		return casesService.getOpen();
	}
	
	@PostMapping("/{buyId}/{employeeId}/cases")
	public Cases save(@PathVariable(value = "buyId") long buyId,@PathVariable(value = "employeeId") long employeeId,@RequestBody Cases casesObj) {
		casesService.save(buyId, employeeId, casesObj);
		return casesObj;
	}
	
	@PutMapping("/{buyId}/{employeeId}/cases")
	public Cases update(@PathVariable(value = "buyId") long buyId,@PathVariable(value = "employeeId") long employeeId,@RequestBody Cases casesObj) {
		casesService.save(buyId, employeeId, casesObj);
		return casesObj;
	}
	
	@DeleteMapping("/cases/{id}")
	public String delete(@PathVariable long id) {
		casesService.delete(id);
		return "Cases has been deleted with id:"+id;
	}

}
