<%-- 
    Document   : header
    Created on : Aug 8, 2023, 10:05:01 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url value="/" var="action"/>
<c:choose>
    <c:when test="${pageContext.request.userPrincipal.name != null}">
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" href="${action}">Trang chủ</a>
                    </li>
                    <sec:authorize access="hasRole('ROLE_USER')"> 
                        <ul class="navbar-nav">
                            <c:forEach items="${hosts}" var="h">
                                <c:url value="/listroom" var="searchUrl">
                                    <c:param name="hId" value="${h.id}" />
                                </c:url>
                                <li class="nav-item">
                                    <a class="nav-link" href="${searchUrl}">${h.name}</a>
                                </li>
                            </c:forEach> 
                        </ul>
                    </sec:authorize>                   
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/"/>">Chào ${pageContext.request.userPrincipal.name}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout"/>">Đăng xuất</a>
                    </li>   
                </ul>
                <form class="d-flex" action="${action}listroom">
                    <input class="form-control me-2" type="text" name="kw" placeholder="tìm kiếm...">
                    <button class="btn btn-primary" type="submit">Tìm</button>
                </form>
            </div>
        </nav>
    </c:when>
    <c:otherwise>
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid ">
                <ul class="navbar-nav ">
                    <li class="nav-item">
                        <a class="nav-link active" href="${action}">Trang chủ</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/register"/>">Đăng ký</a>
                    </li>
                </ul>
            </div>
        </nav>
    </c:otherwise>
</c:choose>

