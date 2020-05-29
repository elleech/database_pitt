package infsci2710.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infsci2710.finalproject.dao.BuyDAO;
import infsci2710.finalproject.model.Buy;

@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	private BuyDAO buyDAO;
	
	@Transactional
	@Override
	public List<Buy> getAll() {
		return buyDAO.getAll();
	}

	@Transactional
	@Override
	public Buy getById(long id) {
		return buyDAO.getById(id);
	}
	
	@Transactional
	@Override
	public List<Buy> getByCustomer(long customerId) {
		return buyDAO.getByCustomer(customerId);
	}

	@Transactional
	@Override
	public void save(long customerId, long productId, long salespersonId, Buy buy) {
		buyDAO.save(customerId, productId, salespersonId, buy);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		buyDAO.delete(id);
		
	}

	

}
