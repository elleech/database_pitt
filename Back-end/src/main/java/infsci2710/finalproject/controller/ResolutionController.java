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

import infsci2710.finalproject.model.Resolution;
import infsci2710.finalproject.service.ResolutionService;


@RestController
@RequestMapping("/api")
public class ResolutionController {
	
	@Autowired
	private ResolutionService resolutionService;
	
	@GetMapping("/resolution")
	public List<Resolution> getAll(){
		return resolutionService.getAll();
	}
	
	@GetMapping("/resolution/{id}")
	public Resolution getById(@PathVariable long id) {
		Resolution resolutionObj= resolutionService.getById(id);
		if(resolutionObj==null) {
			throw new RuntimeException("Resolution with id"+id+" is not found");
		}
		return resolutionObj;
	}
	
	@GetMapping("/resolution/product/{productId}")
	public List<Resolution> getByProduct(@PathVariable long productId){
		return resolutionService.getByProduct(productId);
	}
	
	@PostMapping("/{productId}/resolution")
	public Resolution save(@PathVariable(value = "productId") long productId,@RequestBody Resolution resolutionObj) {
		resolutionService.save(productId, resolutionObj);
		return resolutionObj;
	}
	
	@PutMapping("/{productId}/resolution")
	public Resolution update(@PathVariable(value = "productId") long productId,@RequestBody Resolution resolutionObj) {
		resolutionService.save(productId, resolutionObj);
		return resolutionObj;
	}
	
	@DeleteMapping("/resolution/{id}")
	public String delete(@PathVariable long id) {
		resolutionService.delete(id);
		return "Resolution has been deleted with id:"+id;
	}

}
