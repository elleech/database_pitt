package infsci2710.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infsci2710.finalproject.dao.ProductDAO;
import infsci2710.finalproject.model.Product;
import infsci2710.finalproject.model.Resolution;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Transactional
	@Override
	public List<Product> getAll() {
		return productDAO.getAll();
	}

	@Transactional
	@Override
	public Product getById(long id) {
		return productDAO.getById(id);
	}

	@Transactional
	@Override
	public List<Resolution> getResolution(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void save(Product product) {
		productDAO.save(product);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		productDAO.delete(id);
		
	}

}
