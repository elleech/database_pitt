package infsci2710.finalproject.controller;

//import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import infsci2710.finalproject.model.Casecomment;
import infsci2710.finalproject.service.CasecommentService;


@RestController
@RequestMapping("/api")
public class CasecommentController {
	
	@Autowired
	private CasecommentService casecommentService;
	
	@GetMapping("/casecomment")
	public List<Casecomment> getAll(){
		return casecommentService.getAll();
	}
	
	@GetMapping("/casecomment/{id}")
	public Casecomment getById(@PathVariable long id) {
		Casecomment casecommentObj= casecommentService.getById(id);
		if(casecommentObj==null) {
			throw new RuntimeException("Casecomment with id"+id+" is not found");
		}
		return casecommentObj;
	}
	
	@GetMapping("/casecomment/cases/{casesid}")
	public List<Casecomment> getByCases(@PathVariable long casesid){
		return casecommentService.getByCases(casesid);
	}
	
	//<add> 
	//@GetMapping("/casecomment/date/{date}")
	//public List<Casecomment> getByDate(@PathVariable Date date){
	//	return casecommentService.getByDate(date);
	//}
	
	@PostMapping("/{casesId}/casecomment")
	public Casecomment save(@PathVariable(value = "casesId") long casesId,@RequestBody Casecomment casecommentObj) {
		casecommentService.save(casesId, casecommentObj);
		return casecommentObj;
	}
	
	@PutMapping("/{casesId}/casecomment")
	public Casecomment update(@PathVariable(value = "casesId") long casesId,@RequestBody Casecomment casecommentObj) {
		casecommentService.save(casesId, casecommentObj);
		return casecommentObj;
	}
	
	@DeleteMapping("/casecomment/{id}")
	public String delete(@PathVariable long id) {
		casecommentService.delete(id);
		return "Casecomment has been deleted with id:"+id;
	}

}
