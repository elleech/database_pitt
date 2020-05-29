package infsci2710.finalproject.dao;

import java.util.List;

import infsci2710.finalproject.model.Product;
import infsci2710.finalproject.model.Resolution;


public interface ProductDAO {
	
    List<Product> getAll();
	
	Product getById(long id);
	
	List<Resolution> getResolution(long id);
	
	void save(Product product);
	
	void delete(long id);

}
