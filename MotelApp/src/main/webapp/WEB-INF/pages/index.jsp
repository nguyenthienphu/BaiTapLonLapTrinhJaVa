<%-- 
Document   : index
Created on : Aug 6, 2023, 4:23:18 PM
Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:choose>
    <c:when test="${pageContext.request.userPrincipal.name == null}">
        <h1 class="text-center text-success mt-2">CHÀO MỪNG TỚI TRANG WEB QUẢN LÝ NHÀ TRỌ</h1>
    </c:when>
    <c:otherwise>

        <sec:authorize access="hasRole('ROLE_ADMIN')"> 
            <h1 class="text-center text-success mt-2">CHÀO MỪNG ${pageContext.request.userPrincipal.name} TỚI TRANG WEB QUẢN LÝ NHÀ TRỌ</h1>
            <div>
                <a href="<c:url value="/listhost"/>" class="btn btn-info mb-2">Danh sách chủ phòng</a>
            </div>
            <div>
                <a href="<c:url value="/listroom"/>" class="btn btn-info mb-2">Danh sách phòng</a>
            </div>
            <div>
                <a href="<c:url value="/listuser"/>" class="btn btn-info mb-2">Danh sách User</a>
            </div>
        </sec:authorize>
            
        <sec:authorize access="hasRole('ROLE_USER')"> 
            ROLE_USER
        </sec:authorize> 

        <sec:authorize access="hasRole('ROLE_HOST')"> 
            <c:url value="/listroom" var="action"/>
            <h1 class="text-center text-success mt-2">CHÀO MỪNG ${pageContext.request.userPrincipal.name} TỚI TRANG WEB QUẢN LÝ NHÀ TRỌ</h1>
            <div>
                <a href="<c:url value="/listroom"/>" class="btn btn-info">Danh sách phòng</a>
            </div>
        </sec:authorize> 

    </c:otherwise>
</c:choose>
            

            





