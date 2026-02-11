package org.springMvc.repo;

import org.springMvc.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empRepo")
public class EmpRepoImpl implements EmpRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(Emp e) {
		return jdbcTemplate.update("insert into emp values(?,?,?)",e.getEid(),e.getEname(),e.getSal());
	}

}
