<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    
    <h2 style="color:red;text-align:center"><%=request.getUserPrincipal().getName() %> is not Authroized to access this web page </h2>
    <br><br>
    
    <a href="../index.jsp">home</a>
