package org.springMvc.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springMvc.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("empRepo")
public class EmpRepoImpl implements EmpRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(Emp e) {
		 jdbcTemplate.update("insert into emp values(?,?,?)",e.getEid(),e.getEname(),e.getSal());
	}

	@Override
	public List<Emp> display() {
	
		List<Emp> list=jdbcTemplate.query("select * from emp",new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp e=new Emp();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setSal(rs.getInt(3));
				return e;
			}
		});
		return list;
	}

	@Override
	public List<Emp> search(int eid) {
		List<Emp> list=jdbcTemplate.query("select * from emp where eid=?",new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp e=new Emp();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setSal(rs.getInt(3));
				return e;
			}
		},eid);   //query(sql,rowMapper,paramter(?)
		return list;
		}

	@Override
	public void update(Emp e) {
	   jdbcTemplate.update("update emp set ename=?,sal=? where eid=?",e.getEname(),e.getSal(),e.getEid());
	}

	@Override
	public void delete(int eid) {
		// TODO Auto-generated method stub
		 jdbcTemplate.update("delete from emp where eid=?",eid);
	}

}
