<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/16/2019
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>My Account</title>
    <link rel="stylesheet" href="/view/client/css/form.css">
    <link rel="stylesheet" href="/view/client/css/header.css">
</head>
<body>
<!--header-->
<%@include file="header.jsp"%>

<!--Thông tin khách hàng-->
<div class="cart">
    <h3>Thông tin khách hàng</h3>
    <form class="form-horizontal" action="/myAccount" style="margin-right: 160px;" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Tên:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="Nhập họ và tên" name="name"value="${user.tenKH}" >
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="soDT">Số điện thoại:</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="soDT" placeholder="Nhập số điện thoại" name="soDT" value="${user.soDT}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Email:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" placeholder="Nhập email" name="email" value="${user.email}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="password" placeholder="Nhập email" name="password" value="${user.password}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="diaChi">Địa Chỉ:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="diaChi" placeholder="Nhập địa chỉ" name="diaChi" value="${user.diaChi}" >
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" style="background-color: #4CAF50;" >Update.</button>
            </div>
        </div>
    </form>
</div>
<!--footer-->
<%@include file="footer.jsp"%>
</body>
</html>
