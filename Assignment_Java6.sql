CREATE DATABASE Assignment_Java6;
GO

USE Assignment_Java6;
GO

-- Tạo bảng SanPham
CREATE TABLE san_pham (
    idSP INT IDENTITY(1,1) PRIMARY KEY,
    maSP VARCHAR(50),
    ten NVARCHAR(100),
    trang_thai BIT
);

-- Tạo bảng MauSac
CREATE TABLE mau_sac (
    id_mau_sac INT IDENTITY(1,1) PRIMARY KEY,
    maMS VARCHAR(50),
    tenMS NVARCHAR(100),
    trang_thai BIT
);

-- Tạo bảng KichThuoc
CREATE TABLE kich_thuoc (
    id_kich_thuoc INT IDENTITY(1,1) PRIMARY KEY,
    maKT VARCHAR(50),
    tenKT NVARCHAR(100),
    trang_thai BIT
);

-- Tạo bảng SPChiTiet
CREATE TABLE san_pham_chi_tiet (
    idSPCT INT IDENTITY(1,1) PRIMARY KEY,
    maSPCT VARCHAR(50),
    id_san_pham INT,
    id_mau_sac INT,
    id_kich_thuoc INT,
    so_luong INT,
    don_gia DECIMAL(10, 2),
    trang_thai BIT,
    FOREIGN KEY (id_san_pham) REFERENCES san_pham(idSP),
    FOREIGN KEY (id_mau_sac) REFERENCES mau_sac(id_mau_sac),
    FOREIGN KEY (id_kich_thuoc) REFERENCES kich_thuoc(id_kich_thuoc)
);

-- Tạo bảng KhachHang
CREATE TABLE khach_hang (
    idKH INT IDENTITY(1,1) PRIMARY KEY,
    maKH VARCHAR(50),
    tenKH NVARCHAR(100),
    sdt VARCHAR(20),
    trang_thai BIT
);

-- Tạo bảng nhan_vien
CREATE TABLE nhan_vien (
    idNV INT IDENTITY(1,1) PRIMARY KEY,
    maNV VARCHAR(50),
    ten NVARCHAR(50),
    ten_dang_nhap VARCHAR(50),
    mat_khau VARCHAR(50),
    vai_tro VARCHAR(50),
    trang_thai BIT
);
-- Tạo bảng HoaDon
CREATE TABLE hoa_don (
    id_hoa_don INT IDENTITY(1,1) PRIMARY KEY,
    id_khach_hang INT,
    id_nhan_vien INT,
    ngay_mua_hang DATE,
    trang_thai NVARCHAR(50),
    FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(idKH),
    FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(idNV)
);
select * from hoa_don_chi_tiet
delete  hoa_don_chi_tiet
insert into hoa_don
values (2,2,'2023-09-10',N'Chưa Thanh Toán')
-- Tạo bả''''ng HoaDonChiTiet
CREATE TABLE hoa_don_chi_tiet (
    idHDCT INT IDENTITY(1,1) PRIMARY KEY,
    id_hoa_don INT,
    id_spct INT,
    so_luong INT,
    don_gia DECIMAL(10, 2),
    trang_thai BIT,
    FOREIGN KEY (id_hoa_don) REFERENCES hoa_don(id_hoa_don),
    FOREIGN KEY (id_spct) REFERENCES san_pham_chi_tiet(idSPCT)
);

-- Thêm dữ liệu vào bảng SanPham
INSERT INTO san_pham (maSP, ten, trang_thai)
VALUES 
('GUCCI001', N'Áo Gucci Xanh', 1),
('GUCCI002', N'Áo Gucci Đỏ', 1),
('GUCCI003', N'Áo Gucci Trắng', 1),
('GUCCI004', N'Áo Gucci Đen', 1);

-- Thêm dữ liệu vào bảng MauSac
INSERT INTO mau_sac (maMS, tenMS, trang_thai)
VALUES 
('MS001', N'Xanh', 1),
('MS002', N'Đỏ', 1),
('MS003', N'Trắng', 1),
('MS004', N'Đen', 1);

-- Thêm dữ liệu vào bảng KichThuoc
INSERT INTO kich_thuoc (maKT, tenKT, trang_thai)
VALUES 
('KT001', N'S', 1),
('KT002', N'M', 1),
('KT003', N'L', 1),
('KT004', N'XL', 1);

-- Thêm dữ liệu vào bảng SPChiTiet
INSERT INTO san_pham_chi_tiet (maSPCT, id_san_pham, id_mau_sac, id_kich_thuoc, so_luong, don_gia, trang_thai)
VALUES 
('SPCT001', 1, 2, 2, 10, 1999, 0),
('SPCT002', 1, 2, 2, 50, 2099, 1),
('SPCT003', 2, 2, 1, 80, 2199, 1),
('SPCT004', 3, 3, 3, 60, 2299, 1),
('SPCT005', 4, 4, 4, 40, 2399, 1);
select * from san_pham_chi_tiet
-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO khach_hang (maKH, tenKH, sdt, trang_thai)
VALUES 
('KH001', N'Nguyễn Văn A', '0123456789', 1),
('KH002', N'Trần Thị B', '0987654321', 1),
('KH003', N'Lê Văn C', '0912345678', 1);

-- Thêm dữ liệu vào bảng nhan_vien
INSERT INTO nhan_vien (maNV, ten, ten_dang_nhap, mat_khau, vai_tro, trang_thai)
VALUES 
('NV001', N'Nguyen Van C', 'NguyenVanC', '123', 'Admin', 1),
('NV002', N'Nguyen Van D', 'NguyenVanD', '123', 'User', 0);
