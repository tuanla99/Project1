<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 11/9/2019
  Time: 12:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/client/css/header.css" type="text/css" media="all" >
</head>
<body>
<!--Header-->
<div class="header">
    <div class="logo">
        <a href="#" class="Home"> <img src="${pageContext.request.contextPath}/view/client/img/Logo.png" alt=""> </a>
    </div>
    <div class="menu">
        <div class="tim_kiem">
            <h3>Bạn cần gì?</h3>
            <input class="tim_kiem_byName" name="tim_kiem" type="search" placeholder="search">
            <input class="submit" type="submit" value="Search">
        </div>
        <div class="danh_sach">
            <ul class="_1">
                <li>
                    <a href="#">THƯƠNG HIỆU</a>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath}/searchProductByNSX?nsx=APPLE"> APPLE</a></li>
                        <li><a href="${pageContext.request.contextPath}/searchProductByNSX?nsx=SAMSUNG">SAMSUNG</a></li>
                        <li><a href="${pageContext.request.contextPath}/searchProductByNSX?nsx=OPPO">OPPO </a></li>
                        <li><a href="${pageContext.request.contextPath}/searchProductByNSX?nsx=XIAOMI"> XIAOMI</a></li>
                        <li><a href="${pageContext.request.contextPath}/searchProductByNSX?nsx=VSMART">VSMART </a></li>
                        <li><a href="${pageContext.request.contextPath}/searchProductByNSX?nsx=NOKIA">NOKIA </a></li>
                        <li><a href="${pageContext.request.contextPath}/searchProductByNSX?nsx=VIVO">VIVO </a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">SẢN PHẨM BÁN CHẠY</a>
                </li>
                <li>
                    <a href="#">ĐÁNH GIÁ CAO</a>
                </li>
                <li>
                    <a href="#">SẢN PHẨM SALE</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
