package org.springMvc.repo;

import java.util.List;

import org.springMvc.model.Emp;

public interface EmpRepo {
public void save(Emp e);
public List<Emp> display();
public List<Emp> search(int eid);
public void update(Emp e);
public void delete(int eid);
}
