package infsci2710.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infsci2710.finalproject.dao.SalespersonDAO;
import infsci2710.finalproject.model.Salesperson;

@Service
public class SalespersonServiceImpl implements SalespersonService {

	@Autowired
	private SalespersonDAO salespersonDAO;
	
	@Transactional
	@Override
	public List<Salesperson> getAll() {
		return salespersonDAO.getAll();
	}

	@Transactional
	@Override
	public Salesperson getById(long id) {
		return salespersonDAO.getById(id);
	}

	@Transactional
	@Override
	public void save(Salesperson salesperson) {
		salespersonDAO.save(salesperson);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		salespersonDAO.delete(id);
		
	}

}
