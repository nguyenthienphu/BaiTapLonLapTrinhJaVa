<%-- 
    Document   : createRoom
    Created on : Aug 8, 2023, 10:34:36 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-info">THÊM PHÒNG</h1>

<c:url value="/room" var="action"/>
<form:form modelAttribute="room" method="post" action="${action}" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="id" />
    <form:hidden path="image" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name" id="name" placeholder="Tên phòng" name="name" />
        <label for="name">Tên phòng</label>
        <form:errors path="name" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="description" id="description" placeholder="Mô tả phòng" name="description" />
        <label for="description">Mô tả phòng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="price" id="price" placeholder="Giá phòng" name="price" />
        <label for="price">Giá phòng</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="address" id="address" placeholder="Địa chỉ" name="address" />
        <label for="address">Địa chỉ</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="number" name="number" path="number">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </form:select>
        <label for="sel1" class="form-label">Số lượng</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="host" name="host" path="hostId">
            <c:forEach items="${hosts}" var="h">
                <c:choose>
                    <c:when test="${h.id == room.hostId.id}">
                        <option value="${h.id}" selected>${h.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${h.id}">${h.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Danh sách chủ trọ</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file" id="file" />
        <label for="file">Ảnh phòng</label>
        <c:if test="${room.image != null}">
            <img src="${room.image}" width="120" />
        </c:if>
    </div>
    <div class="btn btn-info mb-3 mt-3">
        <button type="submit" class="btn btn-info" >
            <c:choose>
                <c:when test="${room.id != null}">Cập nhật sản phẩm</c:when>
                <c:otherwise>Thêm sản phẩm</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>


