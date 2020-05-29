package infsci2710.finalproject.dao;

//import java.sql.Date;
import java.util.List;

import infsci2710.finalproject.model.Casecomment;


public interface CasecommentDAO {
	
	List<Casecomment> getAll();
	
	Casecomment getById(long id);
	
	List<Casecomment> getByCases(long casesId);
	
	//List<Casecomment> getByDate(Date date);
	
	void save(long casesId, Casecomment casecomment);
	
	void delete(long id);

}
