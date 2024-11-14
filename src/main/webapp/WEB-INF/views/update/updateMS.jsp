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
<form action="/assignment/capnhatMS" method="post" style="padding-left: 10px ; padding-bottom: 0px">
    <p>Mã MS: <input type="text" name="maMS" value="${ms.maMS}"></p>
    <p>Tên MS: <input type="text" name="tenMS" value="${ms.tenMS}"></p>
    <p>Trạng Thái:
        <input type="radio" name="trangThai" value="true" ${ms.trangThai ? "Checked" : ""}>Đang Sử Dụng
        <input type="radio" name="trangThai" value="false" ${ms.trangThai ? "" : "Checked"}>Không Sử Dụng
    </p>
    <button type="submit">Add MS</button>
</form >
</body>
</html>