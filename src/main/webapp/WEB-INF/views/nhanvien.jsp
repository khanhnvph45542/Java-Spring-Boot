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
    .sanpham{
        grid-template-columns: 0.45fr 1.0fr 0.55fr;
        display: grid;
        border: 1px solid rgb(94, 94, 94);
        /*border-radius: 10px;*/
        padding-bottom: 20px;
        height: 680px;
        padding: 5px 5px;
        width: 100%;

    }
    .sp{
        /*border: 1px solid red;*/
        margin-right: 7px;
    }
</style>
<body>
<div class="sanpham">
    <div class="sp">
        <jsp:include page="home.jsp" />
    </div>
<div class="sp" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);border-radius: 10px;">
    <h3 style="padding-left: 180px">Nhân Viên</h3>
    <form action="/assignment/listIDNV" method="post" style="padding-top: 10px; padding-left: 15px ;">
        <p>ID Nhân Viên: <input type="number" name="idNV">
            <button type="submit">Tìm Kiếm</button>
        </p>
    </form>
    <br>
    <form action="/assignment/addNV" method="post" style="padding-left: 10px ; padding-bottom: 0px">
        <p>Mã NV: <input type="text" name="maNV" value="${n.maNV}"></p>
        <p>Tên: <input type="text" name="ten" value="${n.ten}"></p>
        <p>Tên Đăng Nhập: <input type="text" name="tenDangNhap" value="${n.tenDangNhap}"></p>
        <p>Mật Khẩu: <input type="password" name="matKhau" value="${n.matKhau}"></p>
        <p>Vai Trò: <input type="text" name="vaiTro" value="${n.vaiTro}"></p>
        <p>Trạng Thái:
            <input type="radio" name="trangThai" value="true">Đang Đi Làm
            <input type="radio" name="trangThai" value="false">Nghỉ Việc
        </p>
        <button type="submit">Add NV</button>
    </form >
    <span style="color: red">${checkNV}</span>
    <br>
    <h5 style="padding-top:0px">Table Nhân Viên</h5>
    <table border="1">
        <tr>
            <th>ID NV</th>
            <th>Ma NV</th>
            <th>Tên</th>
            <th>Tên Đăng Nhập</th>
            <th>Mật Khẩu</th>
            <th>Vai Trò</th>
            <th>Trạng Thái</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listNV}" var="nv">
            <tr>
                <td><a href="/assignment/updateNV?idNV=${nv.idNV}" style="text-decoration: none; color: black">${nv.idNV}</a></td>
                <td>${nv.maNV}</td>
                <td>${nv.ten}</td>
                <td>${nv.tenDangNhap}</td>
                <td>${nv.matKhau}</td>
                <td>${nv.vaiTro}</td>
                <td>${nv.trangThai}</td>
                <td><a href="/assignment/deleteNV?idNV=${nv.idNV}"
                       style="text-decoration: none; color: black"
                       onclick="return confirm('Ban co muon xoa nhan vien khong')">Xoa</a></td>
            </tr>
            </c:forEach>
        </table>
    </div>







    <div class="sp" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);border-radius: 10px;">
        <h3 style="padding-left: 90px">Update Nhân Viên</h3>
        <form action="/assignment/updateNV?idNV=${g.idNV}" method="post" style="padding-left: 10px ; padding-bottom: 0px">
            <p>Mã NV: <input type="text" name="maNV" value="${g.maNV}"></p>
            <p>Tên: <input type="text" name="ten" value="${g.ten}"></p>
            <p>Tên Đăng Nhập: <input type="text" name="tenDangNhap" value="${g.tenDangNhap}"></p>
            <p>Mật Khẩu: <input type="password" name="matKhau" value="${g.matKhau}"></p>
            <p>Vai Trò: <input type="text" name="vaiTro" value="${g.vaiTro}"></p>
            <p>Trạng Thái:
                <input type="radio" name="trangThai" value="true"  ${g.trangThai ? "checked": ""}>Đang Đi Làm
                <input type="radio" name="trangThai" value="false"  ${g.trangThai ? "": "checked"}>Nghỉ Việc
            </p>
            <button type="submit">Update NV</button>
        </form >
        <span style="color: red">${checknv}</span>
    </div>
</div>
</body>
</html>