package infsci2710.finalproject.service;

//import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infsci2710.finalproject.dao.CasecommentDAO;
import infsci2710.finalproject.model.Casecomment;

@Service
public class CasecommentServiceImpl implements CasecommentService {

	@Autowired
	private CasecommentDAO casecommentDAO;
	
	@Transactional
	@Override
	public List<Casecomment> getAll() {
		return casecommentDAO.getAll();
	}

	@Transactional
	@Override
	public Casecomment getById(long id) {
		return casecommentDAO.getById(id);
	}
	
	@Transactional
	@Override
	public List<Casecomment> getByCases(long casesId){
		return casecommentDAO.getByCases(casesId);
		
	}
	
	//@Transactional
	//@Override
	//public List<Casecomment> getByDate(Date date){
	//	return casecommentDAO.getByDate(date);
		
	//}

	@Transactional
	@Override
	public void save(long casesId, Casecomment casecomment) {
		casecommentDAO.save(casesId, casecomment);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		casecommentDAO.delete(id);
		
	}

}
