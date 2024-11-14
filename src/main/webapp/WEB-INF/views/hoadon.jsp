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
    .hoadon{
        grid-template-columns: 0.45fr 0.77fr 0.78fr;
        display: grid;
        /*border: 1px solid rgb(94, 94, 94);*/
        /*border-radius: 10px;*/
        padding-bottom: 20px;
        height: 680px;
        padding: 5px 5px;
        width: 100%;

    }
    .hd{
        /*border: 1px solid red;*/
        margin-right: 7px;
    }
</style>
<body>
<div class="hoadon">
    <div class="hd">
        <jsp:include page="home.jsp" />
    </div>
    <div class="hd" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);border-radius: 10px;">
        <h3 style="padding-left: 180px">Hóa Đơn</h3>
        ${errorr}
        <div style="padding-top: 10px; padding-left: 15px ;">
            <form action="/assignment/timKiemHD" method="post">
                    ID Hóa Đơn: <input type="number" name="idHoaDonTK">
                    <button type="submit">Tìm Kiếm</button>
            </form>
            <br>
<%--            <form action="" method="post">--%>
<%--                <p>ID Nhân Viên: <input type="text" name="idNhanVien">--%>
<%--                    <button type="submit">Tìm Kiếm</button>--%>
<%--                </p>--%>
<%--            </form>--%>
<%--            <form action="" method="post">--%>
<%--                <p>ID Khách Hàng: <input type="text" name="idKhachHang">--%>
<%--                    <button type="submit">Tìm Kiếm</button>--%>
<%--                </p>--%>
<%--            </form>--%>
            <form action="/assignment/timkiemTrangThaiHD" method="post">
                <p>Trạng Thái:
                    <input type="radio" name="trangTha" value="dathanhtoan">Đã Thanh Toán
                    <input type="radio" name="trangTha" value="chothanhtoan">Chờ Thanh Toán
                    <input type="radio" name="trangTha" value="huythanhtoan">Đã Hủy
                    <button type="submit">Tìm Kiếm</button>
                </p>
            </form>
            <br>
            <br>
            <br>
            <br>
            <br>
            <table border="1">
                <h5>Hóa Đơn</h5>

                <tr>
                    <th>ID Hóa Đơn</th>
                    <th>ID Nhân Viên</th>
                    <th>ID Khách Hàng</th>
                    <th>Ngày Mua Hàng</th>
                    <th>Trạng Thái</th>
                </tr>
                <c:forEach items="${listHDon}" var="hd" varStatus="i">
                    <tr>
                        <td>  <a href="/assignment/ByHDCT/${hd.idHoaDon}" style="text-decoration: none; color: black">${hd.idHoaDon}</a></td>
                        <td>${hd.nhanVien.idNV}</td>
                        <td>${hd.khachHang.idKH}</td>
                        <td>${hd.ngayMuaHang}</td>
                        <td>${hd.trangThai}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="hd" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);border-radius: 10px;">
        <h3 style="padding-left: 180px">Hóa Đơn Chi Tiết</h3>
        <form action="/assignment/timkiemHDCT" method="post" style="padding-top: 10px; padding-left: 15px ;">
            <p>ID Hóa Đơn Chi Tiết: <input type="number" name="idHDCT">
                <button type="submit">Tìm Kiếm</button>
            </p>
        </form>
        <br>
        <h5 style="padding-top:163px">Hóa Đơn Chi Tiết </h5>
        <table border="1">
            <tr>
                <th>ID HDCT</th>
                <th>IDHoaDon</th>
                <th>IDSPCT</th>
                <th>Số Lượng</th>
                <th>Đơn Giá</th>
<%--                <th>Trang Thai</th>--%>
            </tr>
            <c:forEach items="${listHDCT}" var="p">
                <tr>
                    <td>${p.idHDCT}</td>
                    <td>${p.hoaDon.idHoaDon}</td>
                    <td>${p.sanPhamChiTiet.idSPCT}</td>
                    <td>${p.soLuong}</td>
                    <td>${p.donGia}</td>
<%--                    <td>${p.trangThai?"Đã Thanh Toán":"Chưa Thanh Toán"}</td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>