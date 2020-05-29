package infsci2710.finalproject.service;

import java.util.List;

import infsci2710.finalproject.model.Salesperson;

public interface SalespersonService {
	
    List<Salesperson> getAll();
	
	Salesperson getById(long id);
	
	void save(Salesperson salesperson);
	
	void delete(long id);

}
