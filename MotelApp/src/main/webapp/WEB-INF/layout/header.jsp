<%-- 
    Document   : header
    Created on : Aug 8, 2023, 10:05:01 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/" var="action"/>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" href="${action}">Trang chủ</a>
            </li>
            <c:forEach items="${hosts}" var="h">
                <c:url value="/" var="searchUrl">
                    <c:param name="hId" value="${h.id}" />
                </c:url>
                <li class="nav-item">
                    <a class="nav-link" href="${searchUrl}">${h.name}</a>
                </li>
            </c:forEach> 
        </ul>
        <form class="d-flex" action="${action}">
            <input class="form-control me-2" type="text" name="kw" placeholder="tìm kiếm...">
            <button class="btn btn-primary" type="submit">Tìm   </button>
        </form>
    </div>
</nav>