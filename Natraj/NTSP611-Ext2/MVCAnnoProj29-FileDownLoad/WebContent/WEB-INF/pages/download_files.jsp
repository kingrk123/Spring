<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 style="color:red;text-align:center"> List of Downloadable Files</h1>

<c:choose>
    <c:when test="${!empty filesList}">
      <table align="center" border="1" style="background: cyan">
        <tr>
           <th>File name </th> <th> operation </th>
        </tr>
        <c:forEach var="file" items="${filesList}">
               <tr>
                   <td>${file}</td>
                   <td><a href="download.htm?fname=${file}">download</a> </td>
               </tr>
        </c:forEach>
      </table>
    </c:when>
    <c:otherwise>
       <h1 style="color:red;text-align:center">No Files are found </h1>
    </c:otherwise>
</c:choose>
