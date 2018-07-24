<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản Lý Thành Viên</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="QLTV.css" />
    <script src="main.js"></script>
</head>
<body>
    
    <div class="top">
        <div class="container">
            <div id="logo">
                <h3>Quản Lý Thành Viên</h3>
            </div>

            <div id="nameNV"> 
                <p>Xin chào </p>
                <!--Tên nhân viên lấy từ CSDL-->
                <p>Admin</p>
                <div class="dangxuat">
                    <a href="#" class="logout">Đăng xuất</a>
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
            <a href="quan-ly-nhan-vien.jsp" target="blank">
                <input type="button" class="QLNV" value="Quản Lý Nhân Viên">
            </a>
        </div>

        </div>




    </div>

    <div class="main">
        <div class="container">
            <!--bảng này để đổ dữ liệu từ dưới CDSL lên-->
            <div class="table">
                <table id="table1">
                    <p class="title1">DANH SÁCH KHÁCH HÀNG</p>
                    <thead>
                        <tr>
                            <th>Mã khách hàng</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Tên khách hàng</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Địa chỉ</th>
                            <th>Quận</th>
                            <th>Phường</th>
                            <th>Thành phố</th>
                            <th>Quốc giá</th>
                            <th>Zip code</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <jsp:include page="DocThanhVien"></jsp:include>
                    </tbody>
                </table>
            </div>



            <!--Nút Update này để load lại dữ liệu từ CSDL-->
            <div class="update">
                <form action="#" method="GET">
                    <input type="submit" value="Cập nhật danh sách" id="btsub">
                </form>
            </div>
        </div>
    </div>

</body>
</html>