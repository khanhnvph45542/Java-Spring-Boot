<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<style>
    body {
        display: flex;
        height: 100vh;
        margin: 0;
    }
    nav {
        width: 90%;
        background-color: #f0f0f0;
        padding: 10px;
        border-radius: 10px;
        height: 96%;
    }
    #content {
        flex-grow: 1;
        padding: 10px;
    }
    nav ul li{
        list-style: none;
        padding: 25px 28px;
        /*float: left;*/
    /*text-align: center;*/
        font-weight: bold;
        /*border-radius: 18px;*/
        font-size: 25px;
    }
    nav ul li a{
        text-decoration: none;
    }
</style>
<body>
<nav>
    <h2>Cửa Hàng Áo Gucci</h2>
    <ul>
        <li><a href="/assignment/banhang">Bán Hàng</a></li>
        <li><a href="/assignment/sanpham">Sản Phẩm</a></li>
        <li><a href="/assignment/hoadon">Hóa Đơn</a></li>
        <li><a href="/assignment/khachhang">Khách Hàng</a></li>
        <li><a href="/assignment/nhanvien">Nhân Viên</a></li>
        <li><a href="/assignment/thuoctinh">Thuộc Tính</a></li>

    </ul>
        <li>${tennv}</li>
         <li>${vaitro}</li>
    <br>
    <input type="hidden" name="vaitro" value="${vaitro}" style="padding-bottom: 5px">
    <button style="color: white ; background: #ae1b1b"><a href="/assignment/dangnhap"  style="text-decoration: none; color: white">Đăng Nhập</a></button>
</nav>
</body>
</html>