package infsci2710.finalproject.dao;

import java.util.List;

import infsci2710.finalproject.model.Salesperson;


public interface SalespersonDAO {
	
    List<Salesperson> getAll();
	
	Salesperson getById(long id);
	
	void save(Salesperson salesperson);
	
	void delete(long id);

}
