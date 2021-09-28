<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<h1 style="color:red;text-align:center"> Login Page </h1>

<form:form modelAttribute="userCmd">
    <form:errors path="*"/>
    Login username :: <form:input path="user"/><form:errors path="user" cssStyle="color:red"/> <br>
    Login Password :: <form:input path="pwd"/><form:errors path="pwd" cssStyle="color:red"/> <br>
    Date of Joining :: <form:input path="doj"/>(dd-MM-yyyy) <br>
    <input type="submit"  value="Login"/>
</form:form>    
