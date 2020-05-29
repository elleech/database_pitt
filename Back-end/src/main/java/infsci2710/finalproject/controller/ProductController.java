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

import infsci2710.finalproject.model.Product;
import infsci2710.finalproject.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public List<Product> getAll(){
		return productService.getAll();
	}
	
	@GetMapping("/product/{id}")
	public Product getById(@PathVariable long id) {
		Product productObj= productService.getById(id);
		if(productObj==null) {
			throw new RuntimeException("Product with id"+id+" is not found");
		}
		return productObj;
	}
	
	@PostMapping("/product")
	public Product save(@RequestBody Product productObj) {
		productService.save(productObj);
		return productObj;
	}
	
	@PutMapping("/product")
	public Product update(@RequestBody Product productObj) {
		productService.save(productObj);
		return productObj;
	}
	
	@DeleteMapping("/product/{id}")
	public String delete(@PathVariable long id) {
		productService.delete(id);
		return "Product has been deleted with id:"+id;
	}

}
