<%-- 
    Document   : host
    Created on : Aug 12, 2023, 12:06:36 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-info">THÊM CHỦ PHÒNG</h1>
<c:url value="/host" var="action"/>
<form:form modelAttribute="host" method="post" action="${action}" enctype="multipart/form-data">
    <form:hidden path="id" />
    <form:hidden path="image" />
    <form:hidden path="image1" />
    <form:hidden path="image2" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name" id="name" placeholder="Tên chủ phòng" name="name" />
        <label for="name">Tên chủ phòng</label>
        <form:errors path="name" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="address" id="address" placeholder="Địa chỉ" name="address" />
        <label for="address">Địa chỉ</label>
        <form:errors path="address" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="description" id="description" placeholder="Mô tả" name="description" />
        <label for="description">Mô tả</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file" id="file" />
        <label for="file">Ảnh chủ phòng</label>
        <c:if test="${host.image != null}">
            <img src="${host.image}" width="120" />
        </c:if>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file1" id="file1" />
        <label for="file1">Ảnh chủ phòng</label>
        <c:if test="${host.image1 != null}">
            <img src="${host.image1}" width="120" />
        </c:if>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file2" id="file2" />
        <label for="file2">Ảnh chủ phòng</label>
        <c:if test="${host.image2 != null}">
            <img src="${host.image2}" width="120" />
        </c:if>
    </div>
    <div class="btn btn-info mb-3 mt-3">
        <button type="submit" class="btn btn-info" >
            <c:choose>
                <c:when test="${host.id != null}">Cập nhật chủ phòng</c:when>
                <c:otherwise>Thêm chủ phòng</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>

