<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<h1 style="color:red;text-align:center"><spring:message code="register.title" /> </h1>

<form:form modelAttribute="regCmd">
    <spring:message code="register.empName"/><form:input path="empName"/> <br>
    <spring:message code="register.empAddrs"/><form:input path="empAddrs"/> <br>
    <spring:message code="register.empDesg"/><form:input path="empDesg"/> <br>
    <input type="submit"  value="<spring:message code="register.submitCaption"/>"/>
</form:form>    
<br><br>

<a href="?lang=en_us">english</a> &nbsp; &nbsp;&nbsp;&nbsp;
<a href="?lang=fr_FR">French</a> &nbsp; &nbsp;&nbsp;&nbsp;
<a href="?lang=hi_IN">Hindi</a> &nbsp; &nbsp;&nbsp;&nbsp;
<a href="?lang=de_DE">German</a> &nbsp; &nbsp;&nbsp;&nbsp;
<a href="?lang=zh_CN">Chineese</a> &nbsp; &nbsp;&nbsp;&nbsp;

