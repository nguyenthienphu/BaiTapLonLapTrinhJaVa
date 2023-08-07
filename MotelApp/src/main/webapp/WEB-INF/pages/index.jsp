<%-- 
    Document   : index
    Created on : Aug 6, 2023, 4:23:18 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body
        <nav class="navbar ">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">WebSiteName</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Trang chủ</a></li>
                        <c:forEach items="${hosts}" var="h">
                        <li><a href="#">${h.name}</a></li> 
                        </c:forEach>   
                </ul>     
                <c:url value="/" var="action"/>
                <form class="navbar-form navbar-right"  action="${action}">
                    <div class="form-group">
                        <input type="text" class="form-control" name="kw" placeholder="tìm kiếm...">
                    </div>
                    <button type="submit" class="btn btn-default">Tìm kiếm</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>          
            </div>
        </nav>
        <div class="container">
            <section>
                <h1 class="text-center text-success">DANH SÁCH PHÒNG</h1>
                <div>
                    <a href="#" class="btn btn-info">Thêm phòng</a>
                </div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Tên Phòng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${rooms}" var="r">
                            <tr>
                                <td>${r.id}</td>
                                <td>${r.name}</td>
                                <td>
                                    <a href="#" class="btn btn-info">Thêm</a>
                                    <button class="btn btn-warning">Xoá</button>
                                </td>
                            </tr>
                        </c:forEach>  
                    </tbody>
                </table>
            </section>
        </div>
    </body>
</html>
