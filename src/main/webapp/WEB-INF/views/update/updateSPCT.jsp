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
<body>
<form action="/assignment/updateSPCT?idSPCT=${m.idSPCT}" method="post" style="padding-left: 10px">
    <p>Mã SPCT: <input type="text" name="maSPCT" value="${m.maSPCT}">
        <span style="color: red">${checkmaSPCT}</span></p>
    <p>Tên SP: <select name="sanPham" style="width: 170px ; height: 22px">
        <option value="${m.sanPham.idSP}" hidden>${m.sanPham.ten}</option>
        <c:forEach items="${listSP}" var="sp" >
            <option value="${sp.idSP}">${sp.ten}</option>
        </c:forEach>
    </select>
    </p>
    <p>Tên KT: <select name="kichThuoc" style="width: 170px ; height: 22px">
        <option value="${m.kichThuoc.idKichThuoc}" hidden>${m.kichThuoc.tenKT}</option>
        <c:forEach items="${listKT}" var="kt">
            <option value="${kt.idKichThuoc}">${kt.tenKT}</option>
        </c:forEach>
    </select>
    </p>
    <p>Tên MS: <select name="mauSac" style="width: 170px ; height: 22px">
        <option value="${m.mauSac.idMauSac}" hidden>${m.mauSac.tenMS}</option>
        <c:forEach items="${listMS}" var="ms">
            <option value="${ms.idMauSac}" >${ms.tenMS}</option>
        </c:forEach>
    </select>
    </p>
    <p>Số Lượng: <input type="number" name="soLuong" value="${m.soLuong}">
        <span style="color: red">${checkslSPCT}</span></p>
    <p>Đơn Giá: <input type="number" name="donGia" value="${m.donGia}"></p>

    <button type="submit">Update SPCT</button>
</form>
</body>
</html>