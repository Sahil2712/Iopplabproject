<!--
 *Performs  Add Student Controller information where it send alert messages
 *Date Base Used: MySQL
 *External Jar Used: jsp-api-2.2.jar
 *Server: Apache Tomcat Version 9.0 
 *Author :Sahil Rajeev Naik
 *Date started: 20/05/2021
 *Date ended: 	12/06/2021
 *Testing :Raksha Udupi 
-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<%@page import="student_table.Student_Table_Model"%>
<%@page import="common.Common_Things"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<jsp:useBean id="obj_Student_Use_Bean" class="common_use_bean.Student_Use_Bean"></jsp:useBean>
	<jsp:setProperty property="*" name="obj_Student_Use_Bean"/>
	
	<%
			
	
	  
	  
	   
	Student_Table_Model obj_Student_Table_Model=new Student_Table_Model();
	     
	   int flag=obj_Student_Table_Model.insert_student(obj_Student_Use_Bean);
	   
	   if(flag==1){
		   
			
			session.setAttribute("add_student_message","Student Added Successfully");
		
			
			
	   }else{

			 session.setAttribute("add_student_message","Failed");
		 
	   } 
	   
	    
	   
		%>
		
		
		 
		  
		  		 <script type="text/javascript">
						window.location.href="<%=Common_Things.url%>/add-student/";
				</script>
	
	
	  
</body>
</html>