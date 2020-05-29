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

import infsci2710.finalproject.model.Buy;
import infsci2710.finalproject.service.BuyService;

@RestController
@RequestMapping("/api")
public class BuyController {
	
	@Autowired
	private BuyService buyService;
	
	@GetMapping("/buy")
	public List<Buy> getAll() {
		return buyService.getAll();
	}
	
	@GetMapping("/buy/{id}")
	public Buy getById(@PathVariable long id) {
		Buy buyObj= buyService.getById(id);
		if(buyObj==null) {
			throw new RuntimeException("Buy with id"+id+" is not found");
		}
		return buyObj;
	}
	
	@GetMapping("/buy/customer/{customerId}")
	public List<Buy> getByCustomer(@PathVariable long customerId){
		return buyService.getByCustomer(customerId);
	}
	
	@PostMapping("{customerId}/{productId}/{salespersonId}/buy")
	public Buy save(@PathVariable(value = "customerId") long customerId,@PathVariable(value = "productId") long productId,@PathVariable(value = "salespersonId") long salespersonId, @RequestBody Buy buyObj) {
		buyService.save(customerId,productId, salespersonId, buyObj);
		return buyObj;
	}
	
	@PutMapping("{customerId}/{productId}/{salespersonId}/buy")
	public Buy update(@PathVariable(value = "customerId") long customerId,@PathVariable(value = "productId") long productId,@PathVariable(value = "salespersonId") long salespersonId, @RequestBody Buy buyObj) {
		buyService.save(customerId,productId, salespersonId, buyObj);
		return buyObj;
	}
	
	@DeleteMapping("/buy/{id}")
	public String delete(@PathVariable long id) {
		buyService.delete(id);
		return "Buy has been deleted with id:"+id;
	}

}
