<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 11/18/2019
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
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
<%@include file="/view/client/header.jsp" %>
<%@include file="/view/client/slide.jsp" %>

<!-- From dang nhap-->
<form action="${pageContext.request.contextPath}/admin/login" method="post">
    <table width="400" height="200 " border="2" cellpadding="5" align="center" margin="auto" style="margin: auto;left: 100px;align-content: center" >
    <tr>
        <th COLSPAN="2" >ĐĂNG NHẬP</th>
    </tr>
        <tr>
            <td>Username</td>
            <td>
                <input type="text" placeholder="tên đăng nhập" size="40" name="username" >
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <input type="password" placeholder="mật khẩu" size="40" name="password" >
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center" >
                <input type="submit" name="submit" value="LOGIN" >
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center" style="color: red" >${msgErr}</td>
        </tr>
    </table>

</form>

</body>
</html>
