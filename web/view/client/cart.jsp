<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/16/2019
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Giỏ Hàng</title>
    <link rel="stylesheet" href="/view/client/css/header.css">
    <link rel="stylesheet" href="/view/client/css/card.css">
    <link rel="stylesheet" href="/view/client/css/form.css">
</head>
<body>
<!--header-->
<%@include file="header.jsp" %>

<!--Giỏ hàng-->
<c:set value="${0}" var="total" />
<form method="get" action="order">
    <c:forEach items="${sessionScope.cart}" var="cart">
        <div class="gioHang">

            <div class="img">
                <img src="/view/client/img/Product/${cart.value.product.hinhAnh}" alt="">
            </div>
            <div class="name">
                <h4>${cart.value.product.tenSP}</h4>

                <div class="cartItem">
                    Màu:<br>
                    <label class="radio-inline">
                        <input type="text" name="mau" value="${cart.value.product.mauSac}" readonly>
                    </label>
                    <br>
                    Số lượng: <br>
                    <input type="number" name="${cart.value.product.maSP}" value="${cart.value.soLuong}">
                </div>

            </div>
            <div class="tongTien">
                <div class="tamTinh">
                    <h4>Giá gốc(trên mỗi sp) : </h4>
                    <h4> ${cart.value.product.gia*1.25} đ</h4>
                </div>
                <div class="tamTinh">
                    <h4>Giá khuyến mãi(trên mỗi sp) : </h4>
                    <h4> ${cart.value.product.gia} đ</h4>
                </div>
                <div class="tamTinh">
                    <h4>Tổng tiền : </h4>
                    <h4> ${cart.value.product.gia*cart.value.soLuong} đ</h4>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-default" style="margin-left: 140px">Tiếp tục<br>(Chọn hình thức nhận hàng)
        </button>
        <c:set var="total" value="${total +cart.value.product.gia*cart.value.soLuong }" />
    </c:forEach>
</form>
<span style="margin-left: 150px;color: red" >Tổng hóa đơn: ${total} đ </span>

<!--footer-->
<%@include file="header.jsp" %>
</body>
</html>
