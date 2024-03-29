<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/2/2019
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>
    <title>Home</title>
    <link rel="stylesheet" href="css/header.css" type="text/css">

    <title>Header</title>
</head>
<body>
<!--Header-->
<div class="header">


    <div class="topnav">
        <a class="active" href="${pageContext.request.contextPath}/welcome">Home</a>
        <a href="#about">About</a>
        <a href="#contact">Contact</a>
        <a href="${pageContext.request.contextPath}/cart" class="cart">Cart</a>
        <a href="${pageContext.request.contextPath}/login" class="login" >Login</a>
        <a href="${pageContext.request.contextPath}/register" class="register">Register</a>
        <form action="${pageContext.request.contextPath}/searchProductByName" method="GET">
            <input type="text" placeholder="Search..">
            <input type="submit" value="Go" style="margin-top: 5px;  background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;">
        </form>
    </div>
    <img src="${pageContext.request.contextPath}/view/client/img/Logo.png" alt="" class="logo">

</div>
</body>
</html>
