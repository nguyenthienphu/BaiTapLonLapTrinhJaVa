<%-- 
    Document   : listhost
    Created on : Aug 12, 2023, 5:23:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  
<c:choose>
    <c:when test="${pageContext.request.userPrincipal.name != null}">
        <c:url value="/listhost" var="action"/>
        <h1 class="text-center text-success mt-2">DANH SÁCH CHỦ PHÒNG</h1>
        <div>
            <a href="<c:url value="/host"/>" class="btn btn-info mb-2">Thêm chủ phòng</a>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Hình Ảnh</th>
                    <th>Tên Chủ Phòng</th>
                    <th>Mô tả</th>
                    <th>Tiện ích</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${hosts}" var="h">
                    <tr>
                        <td>${h.id}</td>
                        <td><image src="${h.image}" alt="${h.image}" width="200"/></td>
                        <td>${h.name}</td>
                        <td>${h.description}</td>
                        <td>
                            <c:url value="/host/${h.id}" var="api" />
                            <a href="${api}" class="btn btn-info">Cập Nhật</a>
                            <button class="btn btn-warning">Xoá</button>
                            <c:url value="/listroom" var="searchUrl">
                                <c:param name="hId" value="${h.id}" />
                            </c:url>
                            <a class="btn btn-info" href="${searchUrl}">Chi tiết phòng</a>
                        </td>
                    </tr>
                </c:forEach>  
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <h2 class="text-center text-success mt-2">CHÀO MỪNG TỚI TRANG WEB QUẢN LÝ NHÀ TRỌ</h2>
    </c:otherwise>
</c:choose>

