package infsci2710.finalproject.service;

import java.util.List;

import infsci2710.finalproject.model.Resolution;

public interface ResolutionService {

	List<Resolution> getAll();
	
	Resolution getById(long id);
	
	List<Resolution> getByProduct(long productId);
	
	void save(long productId, Resolution resolution);
	
	void delete(long id);
}
