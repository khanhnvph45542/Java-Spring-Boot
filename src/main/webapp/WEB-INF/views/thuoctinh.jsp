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
    .thuoctinh{
        grid-template-columns: 0.45fr 0.77fr 0.78fr;
        display: grid;
        border: 1px solid rgb(94, 94, 94);
        /*border-radius: 10px;*/
        padding-bottom: 20px;
        height: 680px;
        padding: 5px 5px;
        width: 100%;

    }
    .tt{
        /*border: 1px solid red;*/
        margin-right: 7px;
    }
</style>
<body>
<div class="thuoctinh">
    <div class="tt">
        <jsp:include page="home.jsp" />
    </div>
    <div class="tt" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);border-radius: 10px;">
        <h3 style="padding-left: 180px">Màu Sắc</h3>
        <form action="/assignment/listIDMS" method="post" style="padding-top: 10px; padding-left: 15px ;">
            <p>ID Màu Sắc: <input type="number" name="idMS">
                <button type="submit">Tìm Kiếm</button>
            </p>
        </form>
        <br>
        <form action="/assignment/themMS" method="post" style="padding-left: 10px ; padding-bottom: 0px">
            <p>Mã MS: <input type="text" name="maMS" value="${ms.maMS}"></p>
            <p>Tên MS: <input type="text" name="tenMS" value="${ms.tenMS}"></p>
            <p>Trạng Thái:
                <input type="radio" name="trangThai" value="true" ${ms.trangThai ? "Checked" : ""}>Đang Sử Dụng
                <input type="radio" name="trangThai" value="false" ${ms.trangThai ? "" : "Checked"}>Không Sử Dụng
            </p>
            <button type="submit">Add MS</button>
        </form >
        <span style="color: red">${checkMS}</span>

        <h5 style="padding-top:0px">Table Màu Sắc</h5>
        <table border="1">
            <tr>
                <th>ID MS</th>
                <th>Ma MS</th>
                <th>Tên MS</th>
                <th>Trạng Thái</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listMS}" var="ms">
                <tr>
                    <td><a href="/assignment/updateMS?idMauSac=${ms.idMauSac}" style="text-decoration: none; color: black">${ms.idMauSac}</a></td>
                    <td>${ms.maMS}</td>
                    <td>${ms.tenMS}</td>
                    <td>${ms.trangThai?"Đang Sử Dụng": "Không Sử Dụng"}</td>
                    <td><a href="/assignment/xoaMSac?idMauSac=${ms.idMauSac}"
                           style="text-decoration: none; color: black"
                           onclick="return confirm('Ban co muon xoa mau sac khong')">Xoa</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
























    <div class="tt" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);border-radius: 10px;">
        <h3 style="padding-left: 180px">Kích Thước</h3>
        <form action="/assignment/listIDKT" method="post" style="padding-top: 10px; padding-left: 15px ;">
            <p>ID Kích Thước: <input type="number" name="idKT">
                <button type="submit">Tìm Kiếm</button>
            </p>
        </form>
        <br>
        <form action="/assignment/addKT" method="post" style="padding-left: 10px ; padding-bottom: 0px">
            <p>Mã KT: <input type="text" name="maKT" value="${kt.maKT}"></p>
            <p>Tên KT: <input type="text" name="tenKT" value="${kt.tenKT}"></p>
            <p>Trạng Thái:
                <input type="radio" name="trangThai" value="true">Đang Sử Dụng
                <input type="radio" name="trangThai" value="false">Không Sử Dụng
            </p>
            <button type="submit">Add KT</button>
        </form >
        <span style="color: red">${checkKT}</span>

        <h5 style="padding-top:0px">Table Kich Thuoc</h5>
        <table border="1">
            <tr>
                <th>ID KT</th>
                <th>Ma KT</th>
                <th>Tên KT</th>
                <th>Trạng Thái</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listKT}" var="kt">
                <tr>
                    <td><a href="/assignment/updateKT?idKichThuoc=${kt.idKichThuoc}" style="text-decoration: none; color: black">${kt.idKichThuoc}</a></td>
                    <td>${kt.maKT}</td>
                    <td>${kt.tenKT}</td>
                    <td>${kt.trangThai?"Đang Sử Dụng": "Không Sử Dụng"}</td>
                    <td><a href="/assignment/xoaKT?idKichThuoc=${kt.idKichThuoc}"
                           style="text-decoration: none; color: black"
                           onclick="return confirm('Ban co muon xoa kich thuoc khong')">Xoa</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>