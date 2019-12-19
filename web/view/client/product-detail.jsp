<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/14/2019
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết sản phẩm.</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/detailSP.css">
    <link rel="stylesheet" href="css/form.css">

</head>
<body>
<!--header -->
<%@include file="header.jsp"%>

<!--Chi tiết  sản phẩm-->
<div class="detail_product">
    <div class="cot1_img">
        <img src="${pageContext.request.contextPath}/view/client/img/${product.hinhAnh}" alt="">
    </div>
    <div class="cot2">
        <div class="cot2_gia">
            <div class="gia">
                <p>Mua online giá sốc:</p>
                <p>${product.gia*0.9}</p>
            </div>
            <div class="gia">
                <p>Giá thường</p>
                <p>${product.gia}</p>
            </div>
        </div>
        <div class="khuyenMai">
            <ul>
                <li>Trả góp 0%</li>
                <li>Tặng mã giảm giá 5% để mua Laptop</li>
                <li>Giảm 30% Sim Viettel khi mua kèm máy</li>
            </ul>
        </div>
        <div class="" style="margin-top: 20px;" >
            <a href="#"  >MUA NGAY</a><br><br>
            <a href="#" >THÊM VÀO GIỎ HÀNG</a>
        </div>

    </div>
    <div class="cot3">
        <h3>Thông số kĩ thuật</h3>
        <ul>
            <li>Tên sản phẩm    : ${product.tenSP}</li>
            <li>Màn Hình        : ${product.manHinh}</li>
            <li>Camera trước    : 20.0 MP</li>
            <li>Camera sau      : 48MP</li>
            <li>RAM             : ${product.ram} GB</li>
            <li>Bộ nhớ trong    : ${product.rom} GB</li>
            <li>Chíp            : ${product.chip}</li>
            <li>Dung lượng pin  : 3500mhAh</li>
            <li>Nhà sản xuất    : ${product.nhaSX}</li>
        </ul>

    </div>

</div>

<!--footer -->
<%@include file="footer.jsp"%>
</body>
</html>
