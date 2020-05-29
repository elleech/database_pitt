package infsci2710.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infsci2710.finalproject.dao.CustomerDAO;
import infsci2710.finalproject.model.Buy;
import infsci2710.finalproject.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getAll() {
		return customerDAO.getAll();
	}

	@Transactional
	@Override
	public Customer getById(long id) {
		return customerDAO.getById(id);
	}

	@Transactional
	@Override
	public List<Buy> getBuy(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void save(Customer customer) {
		customerDAO.save(customer);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		customerDAO.delete(id);
		
	}

}
