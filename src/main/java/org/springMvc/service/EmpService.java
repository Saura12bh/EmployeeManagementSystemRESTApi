package org.springMvc.service;

import java.util.List;

import org.springMvc.model.Emp;

public interface EmpService {
	public int save(Emp e);
	public List<Emp> display();
	public List<Emp> search(int eid);
	public int update(Emp e);
	public int delete(int eid);
}
