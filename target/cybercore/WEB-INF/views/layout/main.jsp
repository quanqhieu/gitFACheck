<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/28/2023
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <script src="<c:url value="/resources/js/jquery-3.7.1.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <style>
        .navbar {
            height: 60px;
        }

        .sidebar {
            height: calc(100vh - 60px);
        }

        .main-content {
            max-height: calc(100vh - 60px);
            height: 100%;
            overflow-y: auto;
        }
    </style>
</head>
<body>
<!-- Image and text -->
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="/resources/images/images.jpg" width="30" height="30" class="d-inline-block align-top"
             alt="">
        Fresher Academy
    </a>
</nav>
<div class="container-fluid row vw-100">
    <nav class="sidebar col-2 p-0 border-right ">
        <%@include file="../common/sidebar.jsp" %>
    </nav>
    <div class="main-content col-10 pt-3">
        ${pageContent}
    </div>
</div>
</body>
</html>

