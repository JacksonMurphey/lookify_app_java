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
<title>Songs</title>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>

<a href="/songs/new" class="m-4">Add Song</a>
<a href="/search/topten" class="m-4">Top Songs</a>
<a href="/" class="m-4">Home</a>

<form action="/search" class="m-4">
        <input type="text" name="artist"/>
        <input type="submit" value="New Search"/>
</form>   



<h1 class="m-2">Artist Searched: <c:out value="${artist}"/> </h1>  


<table class="m-2 table table-hover">
    <thead>
        <tr>
            <th>Title</th>
            <th>Artist</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></td>
            <td><c:out value="${song.artist}"/></td>
            <td><c:out value="${song.rating}"/></td>
            <td>
                <a href="/delete/${song.id}" class="m-4">delete</a>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>
</html>