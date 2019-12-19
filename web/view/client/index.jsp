<%@ page import="servise.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 12/2/2019
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Chủ</title>
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

    <link rel="stylesheet" href="/view/client/css/header.css" type="text/css">
    <link rel="stylesheet" href="/view/client/css/slide.css" type="text/css">
    <link rel="stylesheet" href="/view/client/css/content.css" type="text/css">
    <link rel="stylesheet" href="/view/client/css/form.css">

    <script src="https://kit.fontawesome.com/439796a7a7.js" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="header.jsp" %>
<%@include file="slide.jsp" %>
<!--Menu -->
<div class="menu" style="padding-left: 40px; padding-right: 40px;">
    <a href="#" class="nsx"><img src="img/NSX/Apple.PNG" alt=""></a>
    <a href="#" class="nsx"><img src="img/NSX/Nokia.JPG" alt=""></a>
    <a href="#" class="nsx"><img src="img/NSX/Oppo.JPG" alt=""></a>
    <a href="#" class="nsx"><img src="img/NSX/Realmi.JPG" alt=""></a>
    <a href="#" class="nsx"><img src="img/NSX/Samsung.JPG" alt=""></a>
    <a href="#" class="nsx"><img src="img/NSX/Vivo.JPG" alt=""></a>
    <a href="#" class="nsx"><img src="img/NSX/Xiaomi.JPG" alt=""></a>

</div>

<%
    ProductService productService = new ProductService();
    int pages = 1;
    if (request.getParameter("pages") != null) {
        pages = Integer.parseInt(request.getParameter("pages"));
    }
    int begin = 0; // Mỗi mục hiển thị 8 sản phẩm.
    begin = (pages - 1) * 8;
    int end = 8;
    end = pages * 8;
    List<Product> products1 = new ArrayList<>();
    products1 = productService.getAll();
    List<Product> products = new ArrayList<>();
    for (int i=begin;i<end;i++){
        Product product = products1.get(i);
        products.add(product);
    }
    int total = products1.size();
    int numOfPage;
    if (total % 8 == 0) {
        numOfPage = total / 8;
    } else numOfPage = total / 8 + 1;
%>

<!--Content-->
<div class="line-content"></div>
<div class="content-product">
    <div class="san_pham_hot">
        <h3 style="padding: 20px;">Sản phẩm hot:</h3>
    </div>
    <div class="content-product-phan">
        <%
            for (Product product : products) {
        %>
        <div class="content-product-1">
            <img src="<%=request.getContextPath()%>/view/client/img/<%=product.getHinhAnh()%>" alt=""
                 class="img-product">
            <p><%=product.getGia()%> vnd</p>
            <a href="<%=request.getContextPath()%>/maSP=<%=product.getMaSP()%>&soLuong=1" style="color: red;">Add to
                Cart</a>
            <br>
            <a href="<%=request.getContextPath()%>/detailProduct?maSP=<%=product.getMaSP()%>">Chi tiết</a>
        </div>
        <%
            }
        %>

        <div class="container">
            <ul class="pagination">
                <% // Hiển thị số trang trước dó.
                    if (pages > 1) {
                %>
                <li class="page-item disabled"><a class="page-link"
                                                  href="<%=request.getContextPath()%>/view/client/index.jsp?pages=<%=pages-1%>">Previous</a>
                </li>
                <%
                    } // Đóng if
                %>
                <%
                    // Hiển thị trang hiện tại.
                    for (int i = 1; i <= numOfPage; i++) {
                        if (pages == i) {

                %>
                <li class="page-item"><%=i%></li>

                <%
                } else {

                %>
                <li class="page-item"><a class="page-link"
                                         href="<%=request.getContextPath()%>/view/client/index.jsp?pages=<%=i%>"><%=i%>
                </a></li>
                <%

                        }// đóng else
                    }// đóng for
                %>

                <% // Hiển thị trang next
                    if (pages < numOfPage) {
                %>

                <li class="page-item"><a class="page-link"
                                         href="<%=request.getContextPath()%>/view/client/index.jsp?pages=<%=pages+1%>">Next</a>
                </li>
                <%
                    }// đóng if
                %>
            </ul>
        </div>
    </div>
<%
%>
    <div class="line-content"></div>

    <div class="san_pham_hot">
        <h3 style="padding: 20px;">Điện thoại mới:</h3>
    </div>
    <div class="content-product-phan">
        <div class="content-product-1">
            <img src="img/Product/Product5.png" alt="">
            <p>Giá 3.450.000 vnd</p>
            <a href="#">Mua Ngay</a>
            <br>
            <a href="#">Chi tiết</a>
        </div>

    </div>
</div>


<!--Footer-->
<div class="line-content"></div>
<%@include file="footer.jsp" %>
</body>
</html>
