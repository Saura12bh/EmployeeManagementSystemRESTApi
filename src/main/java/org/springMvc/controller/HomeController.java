package org.springMvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springMvc.exception.EmpNotFound;
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
import org.springframework.web.bind.annotation.RestController;

@Controller    //->@Controlleradvice
//@RestController  =>controller+responseBody  ->RestControllerAdvice
public class HomeController {
	
	private static final Logger logger=LoggerFactory.getLogger(HomeController.class);
	//service class object
	@Autowired
	EmpService empService;

	@RequestMapping("/")
	public String home()
	{
		logger.info("Application is start");

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
		logger.info("Emp save successfully");
		empService.save(e);
		return "emp save successfully";
		
	}
	
	//display
	@GetMapping("/display")
	@ResponseBody
	public List<Emp> display()   
	{
		logger.info("Emp display successfully");
		List<Emp> list=empService.display();
		return list;
	}
	
	//search
	@GetMapping("/search")
	@ResponseBody
	public List<Emp> search(@RequestParam("eid") int eid)
	{
		logger.warn("Emp id ="+eid);
		List<Emp>list=empService.search(eid);
		return list;
	}
	
	//update
	@PutMapping("/update")
	@ResponseBody
	public String update(@RequestBody Emp e)
	{
		logger.info("update emp succesfully");
			empService.update(e);
			return "emp update sucessfully";
		
		}
	
     // delete 
	@DeleteMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("eid") int eid)
	{
			logger.info("Delete emp succesfully");
			empService.delete(eid);
			return "emp delete Sucessfully";
		
	}
}
