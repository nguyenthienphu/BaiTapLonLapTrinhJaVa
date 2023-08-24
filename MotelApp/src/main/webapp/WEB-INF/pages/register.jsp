<%-- 
    Document   : register
    Created on : Aug 14, 2023, 11:27:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:choose>
    <c:when test="${user.id != null}">
        <h1 class="text-center text-info">THÔNG TIN USER</h1>
    </c:when>
    <c:otherwise>
        <h1 class="text-center text-info">ĐĂNG KÝ</h1>
    </c:otherwise>
</c:choose>

<c:if test="${errMsg != null}" >
    <div class="alert alert-danger">
        ${errMsg}
    </div>   
</c:if>

<c:url value="/register" var="action"/>
<form:form modelAttribute="user" method="post" action="${action}" enctype="multipart/form-data" >
    <form:hidden path="id" />
    <form:hidden path="avatar" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="lastName" id="lastName" placeholder="Họ" name="lastName" />
        <label for="lastName">Họ</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="firstName" id="firstName" placeholder="Tên" name="firstName" />
        <label for="firstName">Tên</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="email" id="email" placeholder="Email" name="email" />
        <label for="email">Email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="phone" id="phone" placeholder="Số điện thoại" name="phone" />
        <label for="phone">Số điện thoại</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="username" id="username" placeholder="Tên đăng nhập" name="username" />
        <label for="username">Tên đăng nhập</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" class="form-control" path="password" id="password" placeholder="Mật khẩu" name="password" />
        <label for="description">Mật khẩu</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" class="form-control" path="confirmPassword" id="confirmPassword" placeholder="Nhập lại mật khẩu" name="confirmPassword" />
        <label for="confirmPassword">Nhập lại mật khẩu</label>
    </div>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="form-floating mb-3 mt-3">
            <form:select class="form-select" id="userRole" name="userRole" path="userRole">
                <option value="ROLE_ADMIN">ROLE_ADMIN</option>
                <option value="ROLE_HOST">ROLE_HOST</option>
                <option value="ROLE_USER">ROLE_USER</option>
            </form:select>
            <label for="sel1" class="form-label">Quyền truy cập</label>
        </div>
    </sec:authorize>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file" id="file"/>
        <label for="avatar">Ảnh</label>
    </div>
    <div class="btn btn-info mb-3 mt-3">
        <button type="submit" class="btn btn-info" >
            <c:choose>
                <c:when test="${user.id != null}">Cập nhật thông tin user</c:when>
                <c:otherwise>Đăng ký</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>



