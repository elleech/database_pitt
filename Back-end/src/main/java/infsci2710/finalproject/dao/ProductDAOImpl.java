package infsci2710.finalproject.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import infsci2710.finalproject.model.Product;
import infsci2710.finalproject.model.Resolution;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Product> getAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Product> query = currentSession.createQuery("from Product", Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public Product getById(long id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Product productObj = currentSession.get(Product.class, id);
		return productObj;
	}

	@Override
	public List<Resolution> getResolution(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Product product) {
		Session currentSession= entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(product);
		
	}

	@Override
	public void delete(long id) {
		Session currentSession= entityManager.unwrap(Session.class);
		Product productObj = currentSession.get(Product.class, id);
		currentSession.delete(productObj);
	}

}
