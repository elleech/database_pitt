package infsci2710.finalproject.dao;

import java.util.List;

import infsci2710.finalproject.model.Resolution;



public interface ResolutionDAO {
	
	List<Resolution> getAll();
	
	Resolution getById(long id);
	
	List<Resolution> getByProduct(long productId);
	
	void save(long productId, Resolution resolution);
	
	void delete(long id);

}
