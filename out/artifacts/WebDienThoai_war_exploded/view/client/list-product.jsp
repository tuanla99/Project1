<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 11/9/2019
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/client/css/content.css">
</head>
<body>


        <div class="content-product">

            <div class="content-product-phan">
        <c:forEach items="${pwelcome}" var="product" >
                <div class="content-product-1">
                    <img src="${pageContext.request.contextPath}/${product.hinhAnh}" alt="" class="img-product">
                    <p>${product.tenSP}</p>
                    <p>${product.gia}</p>
                    <a href="#">Mua Ngay</a>
                </div>
        </c:forEach>
            </div>
        </div>

</body>
</html>
