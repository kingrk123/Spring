<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <h1 style="color:red"><%=request.getUserPrincipal().getName() %> is not authorized  to visit this web page </h1>
    
     <br>
    <a href="home.htm">home</a>  <br><bR>
    
    <a href="logout">Logout</a>
    
