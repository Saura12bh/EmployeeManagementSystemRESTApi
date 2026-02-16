package org.springMvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springMvc.exception.EmpNotFound;
import org.springMvc.model.Emp;
import org.springMvc.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	private static final Logger logger=LoggerFactory.getLogger(EmpServiceImpl.class);
	@Autowired
	EmpRepo empRepo;
	@Override
	public void save(Emp e) {
		 empRepo.save(e);
	}
	@Override
	public List<Emp> display() {
		
		List<Emp> list = empRepo.display();

	    if(list.isEmpty()) {
	    	logger.error("No employee data in database");
	        throw new EmpNotFound("No employees found in database");
	    }
		return empRepo.display();
	}
	@Override
	public List<Emp> search(int eid) {   
		List<Emp> list=empRepo.search(eid);
		if(list.isEmpty())
		{
			throw new EmpNotFound("Emp not found with eid ="+eid);
		}
		return empRepo.search(eid);
	}
	@Override
	public void update(Emp e) {

		List<Emp> list=empRepo.search(e.getEid());
		if(list.isEmpty())
		{
			throw new EmpNotFound("Emp not found with eid ="+e.getEid());
		}
		empRepo.update(e);
	}
	@Override
	public void delete(int eid) {
		
		List<Emp> list=empRepo.search(eid);
		if(list.isEmpty())
		{
			logger.error("emp id not found");
			throw new EmpNotFound("Emp not found with eid ="+eid);
		}
		 empRepo.delete(eid);
	}

}
