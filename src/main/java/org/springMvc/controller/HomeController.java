package org.springMvc.controller;

import org.springMvc.model.Emp;
import org.springMvc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
}
