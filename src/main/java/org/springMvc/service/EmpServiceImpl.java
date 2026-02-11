package org.springMvc.service;

import java.util.List;

import org.springMvc.model.Emp;
import org.springMvc.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepo empRepo;
	@Override
	public int save(Emp e) {
		return empRepo.save(e);
	}
	@Override
	public List<Emp> display() {
		// TODO Auto-generated method stub
		return empRepo.display();
	}
	@Override
	public List<Emp> search(int eid) {
		// TODO Auto-generated method stub
		return empRepo.search(eid);
	}
	@Override
	public int update(Emp e) {
		// TODO Auto-generated method stub
		return empRepo.update(e);
	}
	@Override
	public int delete(int eid) {
		// TODO Auto-generated method stub
		return empRepo.delete(eid);
	}

}
