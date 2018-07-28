<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản Lý Đơn Hàng</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="QLDH.css" />
    <script src="QLDH.js"></script>
</head>
<body>
    <div class="top">
        <div class="container">
            <div id="logo">
                <h3>Quản Lý Đơn Hàng</h3>
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
            <a href="quan-ly-thanh-vien.jsp" target="blank">
                <input type="button" class="QLTV" value="Quản Lý Thành Viên">
            </a>
        </div>

        <div class="dieuhuong">
            <a href="quan-ly-san-pham.jsp" target="blank">
                <input type="button" class="QLSP" value="Quản Lý Sản Phẩm">
            </a>
        </div>
        
        <div class="dieuhuong">
            <a href="quan-ly-nhan-vien.jsp" target="blank">
                <input type="button" class="QLNV" value="Quản Lý Nhân Viên">
            </a>
        </div>

        </div>




    </div>

    <div class="main">
        <div class="container">
            <div class="table">
                <p class="title">
                    DANH SÁCH ĐƠN HÀNG
                </p>
                <table id="sp">
                    <thead>
                        <tr>
                            <th>Mã đơn hàng</th>
                            <th>Mã khách hàng</th>
                            <th>Email</th>
                            <th>Họ khách hàng</th>
                            <th>Tên khách hàng</th>
                            <th>Số điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Phường</th>
                            <th>Quận</th>
                            <th>Chi tiết đơn hàng</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>

                    <tbody>
                        <jsp:include page="DocDonHang"></jsp:include>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>