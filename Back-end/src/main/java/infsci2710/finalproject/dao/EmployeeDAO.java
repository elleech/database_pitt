package infsci2710.finalproject.dao;

import java.util.List;

import infsci2710.finalproject.model.Cases;
import infsci2710.finalproject.model.Employee;


public interface EmployeeDAO {
	
	List<Employee> getAll();
	
	Employee getById(long id);
	
	List<Cases> getCases(long id);
	
	void save(Employee employee);
	
	void delete(long id);	

}
