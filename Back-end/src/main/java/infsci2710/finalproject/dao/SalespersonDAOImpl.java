package infsci2710.finalproject.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import infsci2710.finalproject.model.Salesperson;

@Repository
public class SalespersonDAOImpl implements SalespersonDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Salesperson> getAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Salesperson> query = currentSession.createQuery("from Salesperson", Salesperson.class);
		List<Salesperson> list = query.getResultList();
		return list;
	}

	@Override
	public Salesperson getById(long id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Salesperson salespersonObj = currentSession.get(Salesperson.class, id);
		return salespersonObj;
	}

	@Override
	public void save(Salesperson salesperson) {
		Session currentSession= entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(salesperson);
		
	}

	@Override
	public void delete(long id) {
		Session currentSession= entityManager.unwrap(Session.class);
		Salesperson salespersonObj = currentSession.get(Salesperson.class, id);
		currentSession.delete(salespersonObj);
	}

}
