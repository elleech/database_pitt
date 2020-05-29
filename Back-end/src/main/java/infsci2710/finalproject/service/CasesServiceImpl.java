package infsci2710.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infsci2710.finalproject.dao.CasesDAO;
import infsci2710.finalproject.model.Cases;

@Service
public class CasesServiceImpl implements CasesService {

	@Autowired
	private CasesDAO casesDAO;
	
	@Transactional
	@Override
	public List<Cases> getAll() {
		return casesDAO.getAll();
	}

	@Transactional
	@Override
	public Cases getById(long id) {
		return casesDAO.getById(id);
	}

	@Transactional
	@Override
	public List<Cases> getByEmployee(long employeeId) {
		return casesDAO.getByEmployee(employeeId);
	}
	
	@Transactional
	@Override
	public List<Cases> getByProduct(long productId) {
		return casesDAO.getByProduct(productId);
	}
	
	@Transactional
	@Override
	public List<Cases> getByCustomer(long customerId) {
		return casesDAO.getByCustomer(customerId);
	}
	
	@Transactional
	@Override
	public List<Cases> getByCustomerCompany(String company) {
		return casesDAO.getByCustomerCompany(company);
	}
	
	@Transactional
	@Override
	public List<Cases> getOpen(){
		return casesDAO.getOpen();
	}

	@Transactional
	@Override
	public void save(long buyId, long employeeId, Cases cases) {
		casesDAO.save(buyId, employeeId, cases);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		casesDAO.delete(id);
		
	}

}
