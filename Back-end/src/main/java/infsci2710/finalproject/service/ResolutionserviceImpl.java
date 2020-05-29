package infsci2710.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infsci2710.finalproject.dao.ResolutionDAO;
import infsci2710.finalproject.model.Resolution;

@Service
public class ResolutionserviceImpl implements ResolutionService {

	@Autowired
	private ResolutionDAO resolutionDAO;
	
	@Transactional
	@Override
	public List<Resolution> getAll() {
		return resolutionDAO.getAll();
	}

	@Transactional
	@Override
	public Resolution getById(long id) {
		return resolutionDAO.getById(id);
	}
	
	@Transactional
	@Override
	public List<Resolution> getByProduct(long productId){
		return resolutionDAO.getByProduct(productId);
		
	}

	@Transactional
	@Override
	public void save(long productId, Resolution resolution) {
		resolutionDAO.save(productId, resolution);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		resolutionDAO.delete(id);
		
	}



}
