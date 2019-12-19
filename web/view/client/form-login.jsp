<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/15/2019
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Nhập.</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/view/client/css/header.css">
    <link rel="stylesheet" href="/view/client/css/form.css">
</head>
<body>
<!--header -->
<%@include file="header.jsp"%>

<!--Form login-->
<div class="container">
    <h2 style="color: red; margin-left: 200px;">${mesErr}</h2>
    <form action="/login" method="POST">
        <h3>Đăng nhập: </h3>

        <div class="row">
            <div class="col-25">
                <label for="DIENTHOAI">Số điện thoại :</label>
            </div>
            <div class="col-75">
                <input type="text" id="DIENTHOAI" name="DIENTHOAI" placeholder="Số điện thoại..">
            </div>
        </div>


        <div class="row">
            <div class="col-25">
                <label for="Password">Mật khẩu :</label>
            </div>
            <div class="col-75">
                <input type="password" id="Password" name="Password" placeholder="password">
            </div>
        </div>


        <div class="row">
            <input type="submit" value="Submit">
        </div>


    </form>
</div>

<!--footer-->
<%@include file="footer.jsp"%>
</body>
</html>
