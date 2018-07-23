<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Chi Tiết Sản Phẩm</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="CTSP.css" />
    <script type="text/javascript" src="CTSP.js"></script>
</head>
<body>
    <div class="top">
        <div class="container">
            <div id="logo">
                <h3>Chi Tiết Sản Phẩm</h3>
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

    <div class="hinhanh">
        <div class="container">
            <div class="hinhsp">
                
                <!--Hình sản phẩm-->
                <img src="images\ip7plus.png" class="kichthuoc">
            </div>
        </div>
    </div>

    <div class="main">
        <div class="container">
            <div class="thongtin">
                <div class="tensp">
                    <p>${chitiet.tenSanPham}</p>
                </div>
                <table class="table">
                    <tr>
                        <th>Mã sản phẩm:</th>
                        <td>
                            <input type="text" class="txtsp" id="txtsp" value="${chitiet.ma_san_pham}" disabled>
                        </td>
                    </tr>

                    <tr>
                        <th>Tên sản phẩm:</th>
                        <td>
                            <input type="text" class="txtsp" id="txtsp1" value="${chitiet.tenSanPham}" disabled>
                        </td>
                    </tr>

                    <tr>
                        <th>Hãng sản xuất:</th>
                        <td>
                            <input type="text" class="txtsp" id="txtsp2" value="${chitiet.hangSanXuat}" disabled>
                        </td>
                    </tr>

                    <tr>
                        <th>Tình trạng:</th>
                        <td>
                            <input type="text" class="txtsp" id="txtsp3" value="${chitiet.tinhTrang}" disabled>
                        </td>
                    </tr>

                    <tr>
                        <th>Camera trước:</th>
                        <td>
                            <input type="text" class="txtsp" id="txtsp4" value="${chitiet.camera_truoc}" disabled>
                        </td>
                    </tr>

                    <tr>
                        <th>Camera sau:</th>
                        <td>
                            <input type="text" class="txtsp" id="txtsp5" value="${chitiet.camera_sau}" disabled>
                        </td>
                    </tr>

                    <tr>
                        <th>Dung lượng pin:</th>
                        <td>
                            <input type="text" class="txtsp" id="txtsp6" value="${chitiet.dung_luong_pin}" disabled>
                        </td>
                    </tr>

                    <tr>
                        <th>Màu sắc:</th>
                        <td>
                            <input type="text" class="txtsp" id="txtsp7" value="${chitiet.mau_sac}" disabled>
                        </td>
                    </tr>

                    <tr>
                        <th>Bảo mật:</th>
                        <td>
                            <input type="text" class="txtsp" id="txtsp8" value="${chitiet.bao_mat}" disabled>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <form action="#" method="POST" id="fix">
                                <input type="button" value="Edit" id="btfix" onclick="bt1()">
                                <input type="submit" value="Save" id="btsave">
                            </form>
                        </td>
                    </tr>
                </table>
                
            </div>
        </div>
    </div>
    
    <!--<script>
         var save = document.getElementById("btsave");
         var edit = document.getElementById("btfix");

         edit.onclick = function() {
             save.style.display = "block";
         }
    </script>-->
    
</body>
</html>