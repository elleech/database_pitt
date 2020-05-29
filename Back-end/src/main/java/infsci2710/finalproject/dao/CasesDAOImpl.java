package infsci2710.finalproject.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import infsci2710.finalproject.model.Buy;
import infsci2710.finalproject.model.Cases;
import infsci2710.finalproject.model.Employee;

@Repository
public class CasesDAOImpl implements CasesDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Cases> getAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Cases> query = currentSession.createQuery("from Cases", Cases.class);
		List<Cases> list = query.getResultList();
		return list;
	}

	@Override
	public Cases getById(long id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Cases casesObj = currentSession.get(Cases.class, id);
		return casesObj;
	}

	@Override
	public List<Cases> getByEmployee(long employeeId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Cases> query = currentSession.createQuery("Select c from Cases c where c.status=:open and c.employee.id=:eid", Cases.class);
		query.setParameter("eid", employeeId);
		query.setParameter("open", "Open");
		List<Cases> list = query.getResultList();
		return list;
		
	}
	
	@Override
	public List<Cases> getByProduct(long productId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Cases> query = currentSession.createQuery("Select c from Cases c where c.buy.product.id=:pid", Cases.class);
		query.setParameter("pid", productId);
		List<Cases> list = query.getResultList();
		return list;
		
	}
	
	@Override
	public List<Cases> getByCustomer(long customerId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Cases> query = currentSession.createQuery("Select c from Cases c where c.buy.customer.id=:cid", Cases.class);
		query.setParameter("cid", customerId);
		List<Cases> list = query.getResultList();
		return list;
		
	}
	
	@Override
	public List<Cases> getByCustomerCompany(String company) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Cases> query = currentSession.createQuery("Select c from Cases c where c.buy.customer.company=:ccompany", Cases.class);
		query.setParameter("ccompany", company);
		List<Cases> list = query.getResultList();
		return list;
		
	}
	
	@Override
	public List<Cases> getOpen(){
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Cases> query = currentSession.createQuery("Select c from Cases c where c.status=:open", Cases.class);
		query.setParameter("open", "Open");
		List<Cases> list = query.getResultList();
		return list;
		
	}

	@Override
	public void save(long buyId, long employeeId, Cases cases) {
		Session currentSession= entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, employeeId);
		cases.setEmployee(employeeObj);
		Buy buyObj = currentSession.get(Buy.class, buyId);
		cases.setBuy(buyObj);
		currentSession.saveOrUpdate(cases);
		
	}

	@Override
	public void delete(long id) {
		Session currentSession= entityManager.unwrap(Session.class);
		Cases casesObj = currentSession.get(Cases.class, id);
		currentSession.delete(casesObj);
	}

}
