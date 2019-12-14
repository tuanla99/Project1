<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 11/16/2019
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product By NSX</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/client/css/header.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/client/css/slide.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/client/css/content.css" type="text/css">

</head>
<body>
<%@include file="header.jsp" %>

<%@include file="slide.jsp"%>

<div class="line-content"></div>

<div class="content-product">

    <div class="content-product-phan">
        <c:forEach items="${productByNSX}" var="productByNSX">
            <div class="content-product-1">
                <img src="${pageContext.request.contextPath}/${productByNSX.hinhAnh}" alt="" class="img-product">
                <p>Tên Sp: ${productByNSX.tenSP}</p>
                <p>Giá:    ${productByNSX.gia}</p>
                <a href="#">Mua Ngay</a>
            </div>
        </c:forEach>
    </div>

    <div class="line-content"></div>

</div>
</body>
</html>
