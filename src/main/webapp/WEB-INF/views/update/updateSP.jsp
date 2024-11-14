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
<form action="/assignment/updateSP?idSP=${n.idSP}" method="post" style="padding-left: 10px ; padding-bottom: 190px">
    <p>Mã SP: <input type="text" name="maSP" value="${n.maSP}"><span style="color: red">${checkMaSP}</span></p>
    <p>Tên: <input type="text" name="ten" value="${n.ten}"><span style="color: red">${checkTen}</span></p>
    <p>Trang Thái:
        <input type="radio" name="trangThai" value="true" ${n.trangThai ? "checked" : ""}>Đang Hoạt Động
        <input type="radio" name="trangThai" value="false" ${n.trangThai ? "" : "checked"}>Không Hoạt Động
    </p>
    <button type="submit">Update SP</button>
</form >
</body>
</html>