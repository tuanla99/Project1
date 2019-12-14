create table Admin
(
    admin_id int identity
        constraint Admin_pk
            primary key nonclustered,
    username nvarchar(20) not null,
    password nvarchar(20) not null
)
go

create table KhachHang
(
    MaKH     int identity
        primary key,
    TenKH    nvarchar(50) not null,
    Email    nvarchar(50) not null,
    SoDT     nvarchar(15) not null,
    PassWord nvarchar(50) not null,
    DiaChi   nvarchar(50),
    Role_id  int
)
go

create table CART
(
    cart_id      int identity
        constraint CART_pk
            primary key nonclustered,
    buyDate      date,
    khachhang_id int
        constraint CART_KhachHang_MaKH_fk
            references KhachHang
)
go

create table SanPham
(
    MaSP    int          not null
        constraint SanPham_pk
            primary key nonclustered,
    TenSP   nvarchar(30) not null,
    NhaSX   nvarchar(15),
    GiaBan  float,
    HinhAnh nvarchar(200),
    MANHINH nvarchar(20),
    RAM     int,
    CHIP    nvarchar(20),
    ROM     int,
    MAUSAC  nvarchar(20)
)
go

create table CartItem
(
    id      int identity
        constraint CartItem_pk
            primary key nonclustered,
    SoLuong int,
    Gia     int,
    MaSP    int
        constraint CartItem_SanPham_MaSP_fk
            references SanPham,
    CartID  int
        constraint CartItem_CART_cart_id_fk
            references CART
)
go

create index SanPham_MaSP_index
    on SanPham (MaSP)
go

