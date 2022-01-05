<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
                crossorigin="anonymous">
<meta charset="UTF-8">
<title>New Song</title>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>

<h1 class="m-2">New Song</h1>  
<%-- <a href="/languages/new" class="m-2 btn btn-primary">New Language</a> --%>


<div class="container">
<form:form action="/songs/new" method="post" modelAttribute="song" class="m-4">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:input path="artist"/>
    </p>
    <p>
        <form:label path="rating">Rating(1-10)</form:label>
        <form:errors path="rating"/>
        <form:input type="number" min="1" max="10" path="rating"/>
    </p>  
    <input type="submit" value="Submit"/>
</form:form>   
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>
</html>