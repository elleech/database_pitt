package infsci2710.finalproject.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import infsci2710.finalproject.model.Customer;
import infsci2710.finalproject.model.Product;
import infsci2710.finalproject.model.Salesperson;
import infsci2710.finalproject.model.Buy;

@Repository
public class BuyDAOImpl implements BuyDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Buy> getAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Buy> query = currentSession.createQuery("from Buy", Buy.class);
		List<Buy> list = query.getResultList();
		return list;
	}

	@Override
	public Buy getById(long id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Buy buyObj = currentSession.get(Buy.class, id);
		return buyObj;
	}
	
	@Override
	public List<Buy> getByCustomer(long customerId){
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Buy> query = currentSession.createQuery("Select b from Buy b where b.customer.id=:cid", Buy.class);
		query.setParameter("cid", customerId);
		List<Buy> list = query.getResultList();
		return list;
	}

	@Override
	public void save(long customerId, long productId, long salespersonId, Buy buy) {
		Session currentSession= entityManager.unwrap(Session.class);
		Customer customerObj = currentSession.get(Customer.class, customerId);
		buy.setCustomer(customerObj);
		Product productObj = currentSession.get(Product.class, productId);
		buy.setProduct(productObj);
		Double price=productObj.getPrice();
		Integer quantity=buy.getQuantity();
		buy.setTotalPrice(price*quantity);
		Salesperson salespersonObj = currentSession.get(Salesperson.class, salespersonId);
		buy.setSalesperson(salespersonObj);
		currentSession.saveOrUpdate(buy);
	}

	@Override
	public void delete(long id) {
		Session currentSession= entityManager.unwrap(Session.class);
		Buy buyObj = currentSession.get(Buy.class, id);
		currentSession.delete(buyObj);
		
	}

	

}
