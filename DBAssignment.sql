CREATE DATABASE AssignmentPro1041Loai3  


CREATE TABLE DANHMUC
(
   MaDM  int IDENTITY(1,1) primary key,
   TenDM nvarchar(30) 
)

CREATE TABLE THELOAI
(
   MaTL  int IDENTITY(1,1) primary key,
   TenTL nvarchar(30) 
)

CREATE TABLE NPH
(
   MaNPH int IDENTITY(1,1) primary key,
   TenNPH nvarchar(30) 
)

CREATE TABLE TACGIA
(
   MaTG int IDENTITY(1,1) primary key,
   TenTG nvarchar(30) 
) 
CREATE TABLE NXB(
	
   MaNXB int IDENTITY(1,1) primary key,
   TenNXB nvarchar(30) 
)

CREATE TABLE SACH
(
   MaSach int IDENTITY(1,1) primary key,
   TenSach nvarchar(30) ,
   MaDM  int ,
   MaTL  int  ,
   MaNPH  int  ,
   MaTG  int,
   MaNXB int,
   NamXuatBan  nvarchar(30),
   NgonNgu   nvarchar(30),
   NhomTuoi  nvarchar(20),
   TaiBan   int,
   SoTrang int,
   GiaBan   float ,
   SoLuong  int   ,
   TrangThai  int ,
   FOREIGN KEY(MaDM) REFERENCES  DANHMUC(MaDM),
   FOREIGN KEY(MaTL) REFERENCES  THELOAI(MaTL),
   FOREIGN KEY(MaNPH) REFERENCES  NPH(MaNPH),
   FOREIGN KEY(MaTG) REFERENCES  TACGIA(MaTG),
   FOREIGN KEY(MaNXB) REFERENCES  NXB(MaNXB)
)

CREATE TABLE SANPHAMLOI 
(
   MaSPL int IDENTITY(1,1) primary key,
   MaSach int ,
   SoLuong  int   ,
   MaNPH int,
   LyDoDoi nvarchar(50) ,
   FOREIGN KEY(MaSach) REFERENCES  SACH(MaSach),
   FOREIGN KEY(MaNPH) REFERENCES  NPH(MaNPH)

)

CREATE TABLE CHUCVU
(
   MaCV int IDENTITY(1,1) primary key,
   TenCV nvarchar(30) ,
   
)

CREATE TABLE NHANVIEN 
(
   MaNV int IDENTITY(1,1) primary key,
   TenNV nvarchar(30) ,
   MaCV int ,
   GioiTinh  int ,
   NgaySinh date ,
   DiaChi   nvarchar(50)  ,
   SDT      nvarchar(10) ,
   TaiKhoan nvarchar(30) ,
   MatKhau nvarchar(30) ,
   FOREIGN KEY(MaCV) REFERENCES CHUCVU(MaCV)

)

CREATE TABLE KHACHHANG 
(
   MaKH int IDENTITY(1,1) primary key,
   TenKH nvarchar(30),
   GioiTinh  int ,
   NgaySinh date ,
   DiaChi   nvarchar(50)  ,
   SDT      nvarchar(10) ,
   DiemTichLuy int 
)

CREATE TABLE HOADON  
(
   MaHD int IDENTITY(1,1) primary key,
   MaKH int ,
   MaNV int ,
   NgayTao date ,
   
   TongTien float ,
   TrangThai int ,
   FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH),
    FOREIGN KEY(MaNV) REFERENCES NHANVIEN(MaNV)
)

CREATE TABLE HOADONCT  
(
   MaHDCT int IDENTITY(1,1) primary key,
   MaHD int ,
   MaSACH int ,  
   SoLuong int ,
   DonGia float,
   FOREIGN KEY(MaHD) REFERENCES HOADON(MaHD),
   FOREIGN KEY(MaSach) REFERENCES SACH(MaSach)

)

CREATE TABLE PHIEUTRAHANG  
(
   MaPTH int IDENTITY(1,1) primary key,
   MaHD int ,
   MaKH int ,
   MaNV int ,
   NgayTra  date ,
   SoTienTraLai float ,
   LyDoTra nvarchar(50),
   FOREIGN KEY(MaHD) REFERENCES HOADON(MaHD),
   FOREIGN KEY(MaKH) REFERENCES KHACHHANG(MaKH),
   FOREIGN KEY(MaNV) REFERENCES NHANVIEN(MaNV)

)

CREATE TABLE PHIEUTRAHANGCHITIET 
(
   MaPTH int ,
   MaSach int ,
   SoLuong int ,
   DonGia money,
    
   FOREIGN KEY(MaPTH) REFERENCES PHIEUTRAHANG(MaPTH),
   FOREIGN KEY(MaSach) REFERENCES SACH(MaSach)
   

)


