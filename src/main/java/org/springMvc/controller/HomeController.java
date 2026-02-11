package org.springMvc.controller;

import java.util.List;

import org.springMvc.model.Emp;
import org.springMvc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	//service class object
	@Autowired
	EmpService empService;

	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	/*  using request param with Query String
	 * @PostMapping("/save")
	 * 
	 * @ResponseBody
	 *  public String save(@RequestParam("eid") int
	 * eid,@RequestParam("ename") String ename,@RequestParam("sal") int sal) { Emp
	 * e=new Emp(); e.setEid(eid); e.setEname(ename); e.setSal(sal); int
	 * v=empService.save(e); if(v>0) { return"emp save successfully"; } else {
	 * return "emp not save "; } }
	 */
	
	// using Request body 
	@PostMapping("/save")
	@ResponseBody   
	public String save(@RequestBody Emp e)  
	{
		int v=empService.save(e);
		if(v>0)
		{
			return"emp save succesfully";
		}
		else {
			return "emp not save sucessfully";
		}
	}
	
	//display
	@GetMapping("/display")
	@ResponseBody
	public List<Emp> display()   
	{
		List<Emp> list=empService.display();
		return list;
	}
	
	//search
	@GetMapping("/search")
	@ResponseBody
	public List<Emp> search(@RequestParam("eid") int eid)
	{
		List<Emp>list=empService.search(eid);
		return list;
	}
	
	//update
	@PutMapping("/update")
	@ResponseBody
	public String update(@RequestBody Emp e)
	{
		int v=empService.update(e);
		if(v>0)
		{
			return "emp update sucessfully";
		}else {
			return "emp delete sucessfully";	
		}
		}
	
     // delete 
	@DeleteMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("eid") int eid)
	{
		int v=empService.delete(eid);
		if(v>0)
		{
			return "emp delete Sucessfully";
		}
		else {
			return "emp not deleted";
		}
	}
}
