package infsci2710.finalproject.service;

import java.util.List;

import infsci2710.finalproject.model.Cases;

public interface CasesService {
	
	List<Cases> getAll();
	
	Cases getById(long id);
	
	List<Cases> getByEmployee(long employeeId);
	
	List<Cases> getByProduct(long productId);
	
	List<Cases> getByCustomer(long customerId);
	
	List<Cases> getByCustomerCompany(String company);
	
	List<Cases> getOpen();
	
	void save(long productId, long employeeId, Cases cases);
	
	void delete(long id);

}
