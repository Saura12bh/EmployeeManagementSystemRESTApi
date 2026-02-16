package org.springMvc.exception;

public class EmpNotFound extends RuntimeException{
	public EmpNotFound(String msg)    //emp not found
	{
		super(msg);  
	}
//	public String getErr()
//	{
//		return "emp with not found"; //1
//	}
}
