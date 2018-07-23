<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="images/favicon.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <title>Thêm Nhân Viên</title>
    <link rel="stylesheet" type="text/css" media="screen" href="ThemNV.css" />
    <script src="ThemNV.js"></script>
</head>
<body>
        <div class="top">
                <div class="container">
                    <div id="logo">
                        <h3>Thêm Nhân Viên</h3>
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

        <div class="main">
                <div class="container">
                    <div class="mainform">
                        <form action="ThemNVController" method="POST" class="fSanpham" id="fSanpham" >
                            <div id="left">
                                <table class="bang1">
                                <tr>
                                    <th>Mã Nhân Viên:</th>
                                    <td>
                                        <input type="text" name="txtMaNhanVien" class="txtsp" id="txtsp" value="">
                                    </td>
                                </tr>
    
                                <tr>
                                    <th>Username:</th>
                                    <td>
                                        <input type="text" name="txtusername" class="txtsp" id="txtsp1" value="">
                                    </td>
                                </tr>
    
                                <tr>
                                    <th>Password:</th>
                                    <td>
                                        <input type="password" name="txtpassword" class="txtsp" id="txtsp2" value="">
                                    </td>
                                </tr>
    
                                <tr>
                                    <th>Họ:</th>
                                    <td>
                                        <input type="text" name="txtHoNhanVien" class="txtsp" id="txtsp3" value="">
                                    </td>
                                </tr>
    
                                <tr>
                                    <th>Tên:</th>
                                    <td>
                                        <input type="text" name="txtTenNhanVien" class="txtsp" id="txtsp10" value="">
                                    </td>
                                </tr>
    
                                <tr>
                                    <th>Email:</th>
                                    <td>
                                        <input type="text" name="txtEmail" class="txtsp" id="txtsp4" value="">
                                    </td>
                                </tr>
    
                                <tr>
                                    <th>Số điện thoại:</th>
                                    <td>
                                        <input type="text" name="txtsdt" class="txtsp" id="txtsp5" value="">
                                    </td>
                                </tr>
    
                            </table>
    
                                <div class="btsub">
                                    <input type="submit" value="Thêm" id="btthem">
                                    <input type="button" value="Reset" id="btreset" onclick="reset()">
                                </div>
                            </div>
                            
                            <div id="right">
                                <img id="hinhsp" class="hinhanh">
                                <input type="file" value="Resize Image" id="upImage" onclick="ResizeImage()">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>