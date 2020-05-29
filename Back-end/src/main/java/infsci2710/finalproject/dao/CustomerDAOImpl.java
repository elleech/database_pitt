package infsci2710.finalproject.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import infsci2710.finalproject.model.Buy;
import infsci2710.finalproject.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Customer> getAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> list = query.getResultList();
		return list;
	}

	@Override
	public Customer getById(long id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Customer customerObj = currentSession.get(Customer.class, id);
		return customerObj;
		
	}

	@Override
	public List<Buy> getBuy(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Customer customer) {
		Session currentSession= entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public void delete(long id) {
		Session currentSession= entityManager.unwrap(Session.class);
		Customer customerObj = currentSession.get(Customer.class, id);
		currentSession.delete(customerObj);
	}

}
