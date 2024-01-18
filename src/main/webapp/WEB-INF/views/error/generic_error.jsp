<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/29/2023
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h1>Hum...Something wrong</h1>
<img src="<c:url value="/resources/images/500.png" />"
     alt="Not found page" />
</br> Detail : ${exception }
</br>
</br>
<a href="${pageContext.request.contextPath}">Back to Home page</a>
</body>
</html>