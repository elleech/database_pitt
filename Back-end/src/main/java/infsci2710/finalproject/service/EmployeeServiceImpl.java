package infsci2710.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infsci2710.finalproject.dao.EmployeeDAO;
import infsci2710.finalproject.model.Cases;
import infsci2710.finalproject.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Transactional
	@Override
	public List<Employee> getAll() {
		return employeeDAO.getAll();
	}

	@Transactional
	@Override
	public Employee getById(long id) {
		return employeeDAO.getById(id);
	}

	@Transactional
	@Override
	public List<Cases> getCases(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		employeeDAO.delete(id);
		
	}

}
