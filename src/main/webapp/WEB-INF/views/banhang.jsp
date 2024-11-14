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
    .banhang{
        grid-template-columns: 0.45fr 1.05fr 0.5fr;
        display: grid;
        padding-bottom: 20px;
        height: 680px;
        padding: 5px 5px;
        width: 100%;
    }
    .tableHD{
        grid-template-columns:  1.6fr 0.4fr;
        display: grid;
        padding-bottom: 20px;
    }
    .hoadon{
        border-radius: 10px;
        margin-right: 7px;

    }
</style>
<body>
<div class="banhang">
    <div class="hoadon">
<jsp:include page="home.jsp" />
    </div>

    <div class="hoadon">
        <h3 style="padding-left: 190px">Quầy Bán Áo Gucci</h3>
        <div class="tableHD">
            <div class="buto">

        <table border="1">
            <h5>Hóa Đơn</h5>

            <tr>
<%--                <th>Stt</th>--%>
                <th>ID Hóa Đơn</th>
                <th>ID Nhân Viên</th>
<%--                <th>ID Khach</th>--%>
                <th>Ngày Mua Hàng</th>
                <th>Trạng Thái</th>
            </tr>
            <c:forEach items="${listHD}" var="hd" varStatus="i">
                <tr>
<%--                    <td>${i.count}</td>--%>
                  <td>  <a href="/assignment/getByIDHD?idHoaDon=${hd.idHoaDon}">${hd.idHoaDon}</a></td>
                    <td>${hd.nhanVien.idNV}</td>
                    <td>${hd.ngayMuaHang}</td>
                    <td>${hd.trangThai}</td>
                </tr>
            </c:forEach>
        </table>
            </div>
<%--            <div class="buto">nnnn</div>--%>
        </div>
        <br>

        <table border="1">
            <h5>Giỏ Hàng </h5>
            <tr>
                <th>ID HDCT</th>
                <th>IDHoaDon</th>
                <th>IDSPCT</th>
                <th>Số Lượng</th>
                <th>Đơn Giá</th>
                <th>Thành Tiền</th>
                <th>Sửa Sản Phẩm</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listHDCT}" var="p">
                <tr>
                    <td>${p.idHDCT}</td>
                    <td>${p.hoaDon.idHoaDon}</td>
                    <td>${p.sanPhamChiTiet.idSPCT}</td>
                    <td>${p.soLuong}</td>
                    <td>${p.donGia}</td>
                    <td>${p.donGia * p.soLuong}</td>
                    <td>
                        <form action="/assignment/updateslspgh?idHDCT=${p.idHDCT}" method="post">
                            <input type="hidden" name="idSPCTGH" value="${p.sanPhamChiTiet.idSPCT}">
                            <input type="hidden" name="idHoaD" value="${p.hoaDon.idHoaDon}">
                            <input type="hidden" name="soLuong" value="${p.soLuong}">
                            <input type="number" name="soluongsanphamthaydoi" value="${p.soLuong}" min="1" style="width: 70px">
                        <button type="submit">Update</button>
                        </form>
                    </td>
                    <td>
                        <button><a href="/assignment/deleteHDCT?idHDCT=${p.idHDCT}&&idHoaDon=${q.idHoaDon}" style="width: 70px">Xóa</a></button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <br>

        <table border="1">
            <h5>SPCT</h5>
            <tr>
                <th>ID SPCT</th>
                <th>Mã SPCT</th>
                <th>ID Sản Phẩm</th>
                <th>ID Kích Thước</th>
                <th>ID Màu Sắc</th>
                <th>Số Lượng</th>
                <th>Đơn Giá</th>
                <th>Trạng Thái</th>
                <th>Mua Sản Phẩm</th>
                <th>Thêm Vào Giỏ Hàng</th>
            </tr>
            <c:forEach items="${listSPCT}" var="l">
                <tr>
                    <td>${l.idSPCT}</td>
                    <td>${l.maSPCT}</td>
                    <td>${l.sanPham.idSP}</td>
                    <td>${l.kichThuoc.idKichThuoc}</td>
                    <td>${l.mauSac.idMauSac}</td>
                    <td>${l.soLuong}</td>
                    <td>${l.donGia}</td>
                    <td>${l.trangThai ? "Còn Hàng" : "Hết Hàng"}</td>
                    <td>
                        <form action="/assignment/addGioHang" method="post">
                            <input type="hidden" name="sanPhamChiTiet" value="${l.idSPCT}">
                            <input type="hidden" name="hoaDon" value="${q.idHoaDon}">
<%--                            <input type="hidden" name="idSanPham" value="${l.idSanPham}">--%>
                            <input type="number" name="soLuong" value="1" min="1" max="${l.soLuong}">
                    </td>
                    <td>
                        <button type="submit">Add</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="hoadon" style="padding-left: 10px ;border: 1px solid rgb(94, 94, 94);
">
        <h4 style="padding-left: 100px">Thanh Toán</h4>
        <form action="/assignment/tienthua" method="post">
            <p>ID HD: <input type="number" name="idHoaDon" value="${q.idHoaDon}"></p>
            <p>ID NV: <input type="number" name="nhanVien" value="${idNhanVien}"></p>
            <p>
                ID KH: <select name="khachHang">
                <c:forEach items="${listKH}" var="kh">
                    <option value="${kh.idKH}">${kh.tenKH}</option>
                </c:forEach>
            </select>
            </p>
            <p>Tổng tiền hàng: <input type="number" name="tongTienKhachTra" value="${tongtien}"></p>
            <p>Khách cần trả: <input type="number"  value="${tongtien}" disabled></p>
            <p>Tiền khách đưa: <input type="number" name="tienKhach" min="${tongtien}" value="${tienKhach}"></p>
            <p>Tiền thừa: <input type="number" name="" value="${tienthuatrakhach}" disabled>
                <button type="submit" formaction="/assignment/tienthua" >Tinh</button>
            </p>

<%--        </form>--%>
<%--        <form action="/assignment/thanhToanHD" method="post">--%>

           <div style="padding-left: 22px">
               <button type="submit" formaction="/assignment/thanhToanHD"
                       onclick="return confirm('Ban co muon thanh toan khong')"
                       style="width: 240px; height: 50px; background: #773d3d; color: #f0f0f0;border: 1px solid #ae1b1b; border-radius: 10px; font-size: 15px; font-weight: bold">Thanh Toán</button>
           </div>
        </form>
        <br>
        <div style="grid-template-columns: 0.9fr 1.1fr; display: grid; padding-bottom: 20px;padding-left: 20px ;">

             <div>
                <form action="/assignment/addHD" method="post">
                    <input type="hidden" name="nhanVien" value="${idNhanVien}">
                    <button style="width: 110px; height: 50px; background: #834646; color: #f0f0f0; border-radius: 10px; font-size: 12px; font-weight: bold;border: 1px solid #ae1b1b" type="submit" onclick="return confirm('Ban co muon tao hoa don khong')">Tạo Hóa Đơn</button>
                </form>
             </div>

            <div>
                <form action="/assignment/huyHoaDon?idHoaDon=${q.idHoaDon}" method="post">
                <button style="width: 110px; height: 50px; background: #7e3939; color: #f0f0f0; border-radius: 10px; font-size: 12px;border: 1px solid #ae1b1b; font-weight: bold" type="submit" onclick="return confirm('Ban co muon huy hoa don khong')">Hủy Hóa Đơn</button>
                </form>
            </div>
        </div>
        <br>
        <p style="color: red">${error}</p>

    </div>
</div>
</body>
</html>