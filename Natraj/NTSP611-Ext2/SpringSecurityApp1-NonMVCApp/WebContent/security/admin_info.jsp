<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    
    
    <h1 style="color:red;text-align:center"> Admin Page </h1>
    
    Currently Logged in user name :: <%=request.getUserPrincipal().getName() %> <br> <br>
    
    <a href="../index.jsp">home</a> <br><br>
    <a href="faculty_info.jsp">Faculty Page</a> <br><br>
    
    <a href="../logout"> Logout</a>
    
    
