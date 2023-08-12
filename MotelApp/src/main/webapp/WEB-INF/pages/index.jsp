<%-- 
Document   : index
Created on : Aug 6, 2023, 4:23:18 PM
Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:url value="/" var="action"/>
<h2 class="text-center text-success mt-2">DANH SÁCH PHÒNG</h2>
<div>
    <a href="<c:url value="/host"/>" class="btn btn-info mb-2">Thêm chủ phòng</a>
</div>
<div>
    <a href="<c:url value="/listhost"/>" class="btn btn-info mb-2">Danh sách chủ phòng</a>
</div>
<div>
    <a href="<c:url value="/room"/>" class="btn btn-info">Thêm phòng</a>
</div>
<c:if test="${pages > 1}">
    <ul class="pagination mt-2">
        <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
            <c:forEach begin="1" end="${pages}" var="i" >
                <c:url value="/" var="pageUrl">
                    <c:param name="page" value="${i}" />
                </c:url>
            <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
            </c:forEach>
    </ul>
</c:if>
<c:if test="${!hId.isEmpty}">
    <table class="table">
        <thead>
            <tr>
                <th>id</th>
                <th>Hình Ảnh</th>
                <th>Tên Phòng</th>
                <th>Số Người</th>
                <th>Giá</th>
                <th>Địa chỉ</th>
                
                <th>Tiện ích</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${rooms}" var="r">
                <tr>
                    <td>${r.id}</td>
                    <td><image src="${r.image}" alt="${p.image}" width="200"/></td>
                    <td>${r.name}</td>
                    <td>${r.number}</td>
                    <td>${r.price}</td>
                    <td>${r.address}</td>
                    <td>
                        <c:url value="/room/${r.id}" var="api" />
                        <a href="${api}" class="btn btn-info">Cập Nhật</a>
                        <button class="btn btn-warning" onclick="deleteRoom('${api}')">Xoá</button>
                    </td>
                </tr>
            </c:forEach>  
        </tbody>
    </table>
</c:if>
<script src="<c:url value="/js/main.js" />"></script>


