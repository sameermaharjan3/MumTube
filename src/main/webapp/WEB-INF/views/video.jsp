
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="css/style.css"   rel="stylesheet">
    <div th:replace="/header :: header-css"/>
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
</head>

<body style="background-color:#EEEEEE;">
<video width="320" height="240" controls>
   <%-- <source src= "${MP4_FILE}" type="video/mp4">--%>
<p>Comment page</p>
</video>
</body>
</html>