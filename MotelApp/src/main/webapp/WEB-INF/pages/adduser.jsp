<%-- 
    Document   : adduser
    Created on : Aug 31, 2023, 1:21:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:choose>
    <c:when test="${user.id != null}">
        <h1 class="text-center text-info">THÔNG TIN USER CHỦ PHÒNG</h1>
    </c:when>
    <c:otherwise>
        <h1 class="text-center text-info">ĐĂNG KÝ USER CHỦ PHÒNG</h1>
    </c:otherwise>
</c:choose>

<c:if test="${errMsg != null}" >
    <div class="alert alert-danger">
        ${errMsg}
    </div>   
</c:if>

<c:url value="/adduser" var="action"/>
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
    <div class="form-floating">
        <form:select class="form-select" id="host" name="host" path="hostId">
            <c:forEach items="${hosts}" var="h">
                <c:choose>
                    <c:when test="${h.id == user.hostId.id}">
                        <option value="${h.id}" selected>${h.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${h.id}">${h.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    </div>           
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
