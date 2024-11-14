<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    .khachhang{
        grid-template-columns: 0.45fr 1.0fr 0.55fr;
        display: grid;
        border: 1px solid rgb(94, 94, 94);
        /*border-radius: 10px;*/
        padding-bottom: 20px;
        height: 680px;
        padding: 5px 5px;
        width: 100%;

    }
    .kh{
        /*border: 1px solid red;*/
        margin-right: 7px;
    }
</style>
<body>
<div class="khachhang">
    <div class="kh">
        <jsp:include page="home.jsp" />
    </div>
    <div class="kh" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);border-radius: 10px;">
        <h3 style="padding-left: 180px">Khách Hàng</h3>
        <form action="/assignment/listIDKH" method="post" style="padding-top: 10px; padding-left: 15px ;">
            <p>ID Khách Hàng: <input type="number" name="idKHang">
                <button type="submit">Tìm Kiếm</button>
            </p>
        </form>
        <br>
        <form action="/assignment/addKH" method="post" style="padding-left: 10px ; padding-bottom: 0px">
            <p>Mã KH: <input type="text" name="maKH" value="${kh.maKH}"></p>
            <p>Tên KH: <input type="text" name="tenKH" value="${kh.tenKH}"></p>
            <p>SDT: <input type="text" name="sdt" value="${kh.sdt}"></p>
            <p>Trạng Thái:
                <input type="radio" name="trangThai" value="true">Đang Sử Dụng
                <input type="radio" name="trangThai" value="false">Không Sử Dụng
            </p>
            <button type="submit">Add KH</button>
        </form >
        <span style="color: red">${checkKH}</span>

        <h5 style="padding-top:0px">Table Khach Hang</h5>
        <table border="1">
            <tr>
                <th>ID KH</th>
                <th>Ma KH</th>
                <th>Tên KH</th>
                <th>SDT</th>
                <th>Trạng Thái</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listKH}" var="kh">
                <tr>
                    <td><a href="/assignment/updateKH?idKH=${kh.idKH}" style="text-decoration: none; color: black">${kh.idKH}</a></td>
                    <td>${kh.maKH}</td>
                    <td>${kh.tenKH}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.trangThai?"Đang Sử Dụng": "Không Sử Dụng"}</td>
                    <td><a href="/assignment/deleteKH?idKH=${kh.idKH}"
                           style="text-decoration: none; color: black"
                           onclick="return confirm('Ban co muon xoa khach hang khong')">Xoa</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="kh" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);border-radius: 10px;">
        <h3 style="padding-left: 90px ; padding-bottom: 30px">Update Khách Hàng</h3>
        <form action="/assignment/updateKH?idKH=${d.idKH}" method="post" style="padding-left: 10px ; padding-bottom: 0px">
            <p>Mã KH: <input type="text" name="maKH" value="${d.maKH}"></p>
            <p>Tên KH: <input type="text" name="tenKH" value="${d.tenKH}"></p>
            <p>SDT: <input type="text" name="sdt" value="${d.sdt}"></p>
            <p>Trạng Thái:
                <input type="radio" name="trangThai" value="true" ${d.trangThai ? "checked" :""}>Đang Sử Dụng
                <input type="radio" name="trangThai" value="false" ${d.trangThai ? "" :"checked"}>Không Sử Dụng
            </p>
            <button type="submit">Update KH</button>
        </form >
<%--        <span style="color: red">${checkKH}</span>--%>
    </div>
</div>
</body>
</html>