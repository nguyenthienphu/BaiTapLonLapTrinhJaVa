<%-- 
    Document   : login
    Created on : Aug 14, 2023, 10:32:37 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">ĐĂNG NHẬP</h1>
<c:url value="/login" var="action" />
<form method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="username" placeholder="Tên đăng nhập" name="username">
        <label for="username">Tên đăng nhập</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <input type="password" class="form-control" id="password" placeholder="Mật khẩu" name="password">
        <label for="password">Mật khẩu</label>
    </div>
    
    <div class="form-floating mt-3 mb-3">
        <input type="submit" value="Đăng nhập" class="btn btn-danger" />
    </div>
</form>
