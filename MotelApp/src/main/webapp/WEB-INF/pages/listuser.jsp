<%-- 
    Document   : listuser
    Created on : Aug 15, 2023, 4:25:32 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:url value="/listuser" var="action"/>

<h1 class="text-center text-success mt-2">DANH SÁCH USER</h1>
<div>
    <a href="<c:url value="/register"/>" class="btn btn-info">Thêm User</a>
</div>

<table class="table">
    <thead>
        <tr>
            <th>id</th>
            <th>Hình Ảnh</th>
            <th>FirstName </th>
            <th>LastName</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Username</th>
            <th>UserRole</th>
            <th>Tiện ích</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listuser}" var="u">
            <tr>
                <td>${u.id}</td>
                <td><image src="${u.avatar}" alt="${u.avatar}" width="200"/></td>
                <td>${u.firstName}</td>
                <td>${u.lastName}</td>
                <td>${u.email}</td>
                <td>${u.phone}</td>
                <td>${u.username}</td>
                <td>${u.userRole}</td>
                <td>
                    <c:url value="/user/${u.id}" var="api" />
                    <a href="${api}" class="btn btn-info">Cập Nhật</a>
                    <button class="btn btn-warning">Xoá</button>
                </td>
            </tr>
        </c:forEach>  
    </tbody>
</table>