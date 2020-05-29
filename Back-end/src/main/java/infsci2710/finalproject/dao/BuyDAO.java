package infsci2710.finalproject.dao;

import java.util.List;

import infsci2710.finalproject.model.Buy;


public interface BuyDAO {
	
    List<Buy> getAll();
	
	Buy getById(long id);
	
	List<Buy> getByCustomer(long customerId);
	
	void save(long customerId,long productId,long salespersonId, Buy buy);
	
	void delete(long id);

}
