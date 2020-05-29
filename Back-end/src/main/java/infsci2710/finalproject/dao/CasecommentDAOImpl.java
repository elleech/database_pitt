package infsci2710.finalproject.dao;

//import java.sql.Date;
import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import infsci2710.finalproject.model.Casecomment;
import infsci2710.finalproject.model.Cases;

@Repository
public class CasecommentDAOImpl implements CasecommentDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Casecomment> getAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Casecomment> query = currentSession.createQuery("from Casecomment", Casecomment.class);
		List<Casecomment> list = query.getResultList();
		return list;
	}

	@Override
	public Casecomment getById(long id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Casecomment casecommentObj = currentSession.get(Casecomment.class, id);
		return casecommentObj;
	}
	@Override
	public List<Casecomment> getByCases(long casesId){
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Casecomment> query = currentSession.createQuery("Select c from Casecomment c where c.cases.id=:cid", Casecomment.class);
		query.setParameter("cid", casesId);
		List<Casecomment> list = query.getResultList();
		return list;
		
	}
	
	//@Override
	//public List<Casecomment> getByDate(Date date){
	//	Session currentSession=entityManager.unwrap(Session.class);
		//Query<Casecomment> query = currentSession.createQuery("Select c from Casecomment c where c.date=:date", Casecomment.class);
		//query.setParameter("date", date);
		//List<Casecomment> list = query.getResultList();
		//return list;
		
	//}

	@Override
	public void save(long casesId, Casecomment casecomment) {
		Session currentSession= entityManager.unwrap(Session.class);
		Cases casesObj = currentSession.get(Cases.class, casesId);
		casecomment.setCases(casesObj);
		//LocalDate date=LocalDate.now();
		//casecomment.setDate(Date.valueOf(date));
		//LocalDateTime createdtime = LocalDateTime.now();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		casecomment.settime(timestamp);
		currentSession.saveOrUpdate(casecomment);
		
	}

	@Override
	public void delete(long id) {
		Session currentSession= entityManager.unwrap(Session.class);
		Casecomment casecommentObj = currentSession.get(Casecomment.class, id);
		currentSession.delete(casecommentObj);
		
	}

}
