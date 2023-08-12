<%-- 
    Document   : listhost
    Created on : Aug 12, 2023, 5:23:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/listhost" var="action"/>
<h1 class="text-center text-success mt-2">DANH SÁCH CHỦ PHÒNG</h1>

<table class="table">
    <thead>
        <tr>
            <th>id</th>
            <th>Hình Ảnh</th>
            <th>Tên Chủ Phòng</th>
            <th>Mô tả</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${hosts}" var="h">
            <tr>
                <td>${h.id}</td>
                <td><image src="${h.image}" alt="${h.image}" width="200"/></td>
                <td>${h.name}</td>
                <td>${h.description}</td>
            </tr>
        </c:forEach>  
    </tbody>
</table>

