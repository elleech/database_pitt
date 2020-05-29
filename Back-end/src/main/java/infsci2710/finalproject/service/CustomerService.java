package infsci2710.finalproject.service;

import java.util.List;

import infsci2710.finalproject.model.Buy;
import infsci2710.finalproject.model.Customer;

public interface CustomerService {
	
    List<Customer> getAll();
	
	Customer getById(long id);
	
	List<Buy> getBuy(long id);
	
	void save(Customer customer);
	
	void delete(long id);

}
