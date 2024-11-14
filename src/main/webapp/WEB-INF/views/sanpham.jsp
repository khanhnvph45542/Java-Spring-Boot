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
        grid-template-columns: 0.45fr 0.77fr 0.78fr;
        display: grid;
        /*border: 1px solid rgb(94, 94, 94);*/
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
.formSP{
    /*border: 1px solid red;*/
}
</style>
<body>
<div class="sanpham">
    <div class="sp">
        <jsp:include page="home.jsp" />
    </div>
    <div class="sp" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);border-radius: 10px;">
        <div class="formSP"></div>
      <h3 style="padding-left: 180px">Sản Phẩm</h3>
        <br>
        <form action="/assignment/addSP" method="post" style="padding-left: 10px ; padding-bottom: 190px">
            <p>Mã SP: <input type="text" name="maSP" value="${n.maSP}"><span style="color: red">${checkMaSP}</span></p>
            <p>Tên: <input type="text" name="ten" value="${n.ten}"><span style="color: red">${checkTen}</span></p>
            <button type="submit">Add SP</button>
        </form >
        <br>
        <table border="1" style="width: 450px">
            <tr>
                <th>ID SP</th>
                <th>Mã SP</th>
                <th>Tên SP</th>
                <th>Trạng Thái</th>
<%--                <th>Action</th>--%>
            </tr>
            <c:forEach items="${listSPham}" var="b">
                <tr>
                    <td><a href="/assignment/updateSP/${b.idSP}" style="text-decoration: none; color: black">${b.idSP}</a></td>
                    <td>${b.maSP}</td>
                    <td>${b.ten}</td>
                    <td>${b.trangThai ? "Đang Hoạt Động" : "Không Hoạt Động"}</td>
<%--                    <td><a href="/assignment/deleteSP?idSP=${b.idSP}" style="text-decoration: none; color: black">Xoa</a></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>



    <div class="sp" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);border-radius: 10px;">
        <h3 style="padding-left: 140px">Sản Phẩm Chi Tiết</h3>
        <br>
        <form action="/assignment/addSPCT" method="post" style="padding-left: 10px">
            <p>Mã SPCT: <input type="text" name="maSPCT" value="${m.maSPCT}">
            <span style="color: red">${checkmaSPCT}</span></p>

            <p>Tên SP: <select name="sanPham" style="width: 170px ; height: 22px">
                <c:forEach items="${listSP}" var="sp" >
                    <option value="${sp.idSP}">${sp.ten}</option>
                </c:forEach>
            </select>
            </p>
            <p>Tên KT: <select name="kichThuoc" style="width: 170px ; height: 22px">
                <c:forEach items="${listKT}" var="kt">
                    <option value="${kt.idKichThuoc}">${kt.tenKT}</option>
                </c:forEach>
            </select>
            </p>
            <p>Tên MS: <select name="mauSac" style="width: 170px ; height: 22px">
                <c:forEach items="${listMS}" var="ms">
                    <option value="${ms.idMauSac}" >${ms.tenMS}</option>
                </c:forEach>
            </select>
            </p>
            <p>Số Lượng: <input type="number" name="soLuong" min="1" value="${m.soLuong}">
                <span style="color: red">${checkslSPCT}</span></p>
            <p>Đơn Giá: <input type="number" name="donGia" min="1" value="${m.donGia}">
                <span style="color: red">${checkdgSPCT}</span></p>
            <input type="text" hidden value="true" name="trangThai">
            <button type="submit">Add SPCT</button>
        </form>
        <br>
        <br>
        <br>
        <table border="1">
            <tr>
                <th>ID SPCT</th>
                <th>Mã SPCT</th>
                <th>ID SP</th>
                <th>ID KT</th>
                <th>ID MS</th>
                <th>Số Lượng</th>
                <th>Đơn Giá</th>
                <th>Trạng Thái</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listSPCT}" var="p">
                <tr>
                    <td><a href="/assignment/updateSPCT/${p.idSPCT}" style="text-decoration: none; color: black">${p.idSPCT}</a></td>
                    <td>${p.maSPCT}</td>
                    <td>${p.sanPham.idSP}</td>
                    <td>${p.kichThuoc.idKichThuoc}</td>
                    <td>${p.mauSac.idMauSac}</td>
                    <td>${p.soLuong}</td>
                    <td>${p.donGia}</td>
                    <td>${p.trangThai ? "Còn Hàng" : "Hết Hàng"}</td>
                    <td><a href="/assignment/deleteSPCT?idSPCT=${p.idSPCT}" style="text-decoration: none; color: black">Xoa</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
