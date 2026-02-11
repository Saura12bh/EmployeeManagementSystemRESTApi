<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Enter id
<input type="text" id="eid"><br><br>
Enter name
<input type="text" id="ename"><br><br>
Enter sal
<input type="text" id="sal"><br><br>
<input type="submit" value="Add Emp" onclick="save()"><br><br>

<input type="submit" value="Display Emp" onclick="dis()"><br><br>
<table>
<thead>
<tr><th>eid</th><th>ename</th><th>sal</th></tr>
</thead>
<tbody id="tb"></tbody>
</table><br><br>
  

<!--js code  -->
<script type="text/javascript">
	//save emp 
	function save()
	{	/* data fetch aplya page vrin index */
		/* let eid=document.getElementById("eid").value;
		let ename=document.getElementById("ename").value;
		let sal=document.getElementById("sal").value;  //input filed tr apn value use krto
 */		
		//jevha requestParam use krto tevha
		//save?eid=1&ename="sai"&sal  ->@RequestParam controllrt madhe fetch kraycja asel tr
		//Query String
		/* let data="eid="+eid+"&ename="+ename+"&sal="+sal;
		fetch("save", {//url
			method:"POST", //method nav
			headers:{      //content-type
				"content-Type":"application/x-www-form-urlencoded"
			},
			body:data  //query String
			
		}).
		then((res)=>res.text()).  //text() ->json to string ->Post,get,put json()->get method
		then((r)=>{
			alert("emp save succesfully");
		}).
		catch((err)=>{
			alert(err);
		}); */
	
		//using json with @RequestBody annotation
/* 		let eid=document.getElementById("eid").value;
		let ename=document.getElementById("ename").value;
		let sal=document.getElementById("sal").value;  //input filed tr apn value use krto

		let emp={       //apn yethe js cha obect bnvla ani tyat sagla data save kela 
				eid:eid,
				ename:ename,
				sal:sal
		};
		 */
		//or
		let emp={
				eid:document.getElementById("eid").value,
				ename:document.getElementById("ename").value,
				sal:document.getElementById("sal").value
		};
		
		fetch("save",{
			method:"POST",
			headers:{"content-type":"application/json"},
			body:JSON.stringify(emp)   
		}).
		then((res)=>res.text()).
		then((msg)=>{
			alert(msg);
		}).
		catch((err)=>{
			alert(err);
		})
	}
	
function  dis()
{
	fetch("display").
	then((res)=>res.json()).
	then().
	catch((err)=>{
		alert(err);
	})
}
</script>

</body>
</html>