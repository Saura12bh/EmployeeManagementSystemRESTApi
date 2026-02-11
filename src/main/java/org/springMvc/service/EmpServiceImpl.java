package org.springMvc.service;

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

}
