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
public class ResolutionDAOImpl implements ResolutionDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Resolution> getAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Resolution> query = currentSession.createQuery("from Resolution", Resolution.class);
		List<Resolution> list = query.getResultList();
		return list;
	}

	@Override
	public Resolution getById(long id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Resolution resolutionObj = currentSession.get(Resolution.class, id);
		return resolutionObj;
	}
	
	@Override
	public List<Resolution> getByProduct(long productId){
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Resolution> query = currentSession.createQuery("Select c from Resolution c where c.product.id=:pid", Resolution.class);
		query.setParameter("pid", productId);
		List<Resolution> list = query.getResultList();
		return list;
		
	}

	@Override
	public void save(long productId, Resolution resolution) {
		Session currentSession= entityManager.unwrap(Session.class);
		Product productObj = currentSession.get(Product.class, productId);
		resolution.setProduct(productObj);
		currentSession.saveOrUpdate(resolution);
		
	}

	@Override
	public void delete(long id) {
		Session currentSession= entityManager.unwrap(Session.class);
		Resolution resolutionObj = currentSession.get(Resolution.class, id);
		currentSession.delete(resolutionObj);
	}

	

}
