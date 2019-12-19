<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/18/2019
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edit Product</title>
    <link rel="stylesheet" href="/view/admin/css/form.css">
    <link rel="stylesheet" href="/view/admin/css/header.css">
</head>
<body>
<!--Header-->
<%@include file="/view/client/header.jsp"%>
<!--Thông tin khách hàng-->
<div class="product">
    <h3>Thông tin sản phẩm: </h3>
    <form class="form-horizontal" action="#" style="margin-right: 160px;">
        <div class="form-group">
            <label class="control-label col-sm-2" for="maSP">Mã Sản Phẩm:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="maSP" placeholder="" readonly value="${product.maSP}"  name="maSP">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="tenSP">Tên sản phẩm:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="tenSP" placeholder="Nhập tên sản phẩm" name="tenSP" value="${product.tenSP}" >
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="nhaSX">Nhà SX:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nhaSX" placeholder="Nhập tên nhà sản xuất" name="nhaSX" value="${product.nhaSX}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="giaBan">Giá Bán:</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="giaBan" placeholder="Nhập giá bán" name="giaBan" value="${product.gia}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="hinhAnh">HÌnh Ảnh:</label>
            <div class="col-sm-10">
                <input type="file" class="form-control" id="hinhAnh" placeholder="Chọn hình ảnh:" name="hinhAnh" accept="img">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="manHinh">Màn Hình:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="manHinh" placeholder="Màn hình: " name="manHinh" value="${product.manHinh}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="ram">Ram:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="ram" placeholder="Nhập Ram" name="ram" value="${product.ram}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="chip">Chíp:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="chip" placeholder="Nhập Chíp" name="chip" value="${product.chip}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="rom">Rom:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="rom" placeholder="Nhập Rom" name="rom" value="${product.rom}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="mauSac">Màu sản phẩm:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="mauSac" placeholder="Nhập màu sản phẩm" name="mauSac" value="${product.mauSac}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" style="background-color: #4CAF50;">Update.</button>
            </div>
        </div>
    </form>
</div>
<!--Footer-->
<%@include file="/view/client/footer.jsp"%>
</body>
</html>
