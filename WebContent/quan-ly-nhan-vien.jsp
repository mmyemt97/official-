<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quản Lý Nhân Viên</title>
    <link rel="stylesheet" type="text/css" media="screen" href="QLNV.css" />
</head>
<body>
        <div class="top">
                <div class="container">
                    <div id="logo">
                        <h3>Quản Lý Nhân Viên</h3>
                    </div>
        
                    <div id="nameNV"> 
                        <p>Xin chào </p>
                        <!--Tên nhân viên lấy từ CSDL-->
                        <p>${sessionScope.staff.ten_nhan_vien}</p>
                        <div class="dangxuat">
                            <a href="DangXuat" class="logout">Đăng xuất</a>
                        </div>
        
                    </div>
                </div>
            </div>
        
            <div class="trangkhac">
                <div class="container">
                    
                <div class="dieuhuong">
                    <a href="quan-ly-san-pham.jsp" target="blank">
                        <input type="button" class="QLSP" value="Quản Lý Sản Phẩm">
                    </a>
                </div>
        
                <div class="dieuhuong">
                    <a href="quan-ly-don-hang.jsp" target="blank">
                        <input type="button" class="QLDH" value="Quản Lý Đơn Hàng">
                    </a>
                </div>
        
                <div class="dieuhuong">
                    <a href="quan-ly-thanh-vien.jsp" target="blank">
                        <input type="button" class="QLTV" value="Quản Lý Thành Viên">
                    </a>
                </div>
        
                </div>
        
        
        
        
            </div>
        
            <div class="main">
                <div class="container">
                    <!--bảng này để đổ dữ liệu từ dưới CDSL lên-->
                    <div class="table">
                        <table id="table1">
                            <p class="title1">DANH SÁCH NHÂN VIÊN</p>
                            <thead>
                                <tr>
                                    <th>Mã Nhân Viên</th>
                                    <th>Username</th>
                                    <th>Password</th>
                                    <th>Họ</th>
                                    <th>Tên</th>
                                    <th>Chức Vụ</th>
                                    <th>Email</th>
                                    <th>Số Điện Thoại</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
        
                            <tbody>
                                <jsp:include page="DanhSachNhanVien"></jsp:include>
                            </tbody>
                        </table>
                    </div>
        
        
        
                    <!--Nút Update này để load lại dữ liệu từ CSDL-->
                    <div class="update">
                        <form action="#" method="GET">
                            <a href="them-nhan-vien.jsp" target="_blank">
                                <input type="button" value="Thêm Nhân Viên" id="btsub">
                            </a>
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>