<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Database.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DTO.*" %>
<%@ page import="java.sql.*"%>

<!-- Khách Hàng vào thì in câu này -->
<c:if test="${sessionScope.member != null}">
	<h1> Bạn không có quyền truy cập trang này!</h1>
</c:if>

<!-- Nhân viên chưa đăng nhập vào thì in câu này -->
<c:if test="${sessionScope.member == null}">
	<c:if test="${sessionScope.staff != null}">
		<!DOCTYPE html>
		<html>
		<head>
		    <meta charset="utf-8" />
		    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		    <title>Quản Lý Sản Phẩm</title>
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" type="text/css" media="screen" href="QLHH.css" />
		    <script src="QLHH.js"></script>
		
		    <%!
		    Connection db = Database.connect();
		    Statement stm = null;
		    ResultSet rs = null;
		    String query = "SELECT * FROM san_pham";
		    int soDongTrang = 5, tongSoTrang, trang = 1, viTriDau; // xài cục bộ trong mỗi trang này
		    // nên khai báo trực tiếp
		    
		%>
		<%
		    // lần đầu load trang
		    if(rs == null){
		        stm = db.createStatement(); // tạo kết nói csdl
		        rs = stm.executeQuery(query); // thực thi lệnh truy vấn sql ( 47 results)
		        rs.last();  
		        // quét tới cuối db
		        int tongSoDong = rs.getRow(); // 47 dòng 
		        tongSoTrang = tongSoDong/soDongTrang + (tongSoDong%soDongTrang != 0 ? 1 : 0);//Neu tongsoDong chia sodongtrang ma khong du thi khong add 1 trang moi, neu có dư thì sẽ add 1 trang mới
		        
		    }
		    /*<a href="....?trang=1">*/ // "trang" là Parameter
		    if(request.getParameter("trang") != null)
		        trang = Integer.parseInt(request.getParameter("trang"));
		    viTriDau = (trang-1)*5;  // TRANG 1 (1-1)*5
		    int stt = viTriDau+1;
		    rs = stm.executeQuery(query + " limit " + viTriDau + "," + soDongTrang) ;
		%>
		
		</head>
		<body>
		    <div class="top">
		        <div class="container">
		            <div id="logo">
		                <h3>Quản Lý Sản Phẩm</h3>
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
		                <a href="quan-ly-thanh-vien.jsp" target="blank">
		                    <input type="button" class="QLTV" value="Quản Lý Thành Viên">
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
		
		            <div class="search">
		                <form action="#" method="POST" class="fSearch">
		                    <input type="search" placeholder="Tìm kiếm sản phẩm" id="txtSearch" size="30">
		                    <input type="button" value="" id="btSearch">
		                </form>
		            </div>
		
		        </div>
		
		
		
		
		    </div>
		    
		    <div class="main">
		        <div class="container">
		            <div class="table">
		                <p class="title">DANH SÁCH SẢN PHẨM</p>
		                <table id="sp">
		                    <thead>
		                        <tr>
		                            <th>Mã sản phẩm</th>
		                            <th>Tên sản phẩm</th>
		                            <th>Hãng sản xuất</th>
		                            <th>Giả sản phẩm</th>
		                            <th>Tình trạng</th>
		                            <th>Tính năng</th>
		                            <th>Camera trước</th>
		                            <th>Camera sau</th>
		                            <th>Dung lượng pin</th>
		                            <th>Màu sắc</th>
		                            <th>Bảo mật</th>
		                            <th></th>
		                            <th></th>
		                        </tr>
		                    </thead>
		
		                    <tbody>
		                        <%while(rs.next()){ %>
			                        <tr class="odd">	                            
									    <td><%=rs.getString("ma_san_pham") %></td>
									    <td><a href="DocCTSanPham?id=<%=rs.getString("ma_san_pham")%>"><%=rs.getString("ten_san_pham") %> </a></td>
									    <td><%=rs.getString("hang_san_xuat") %></td>
									    <td><%=rs.getInt("gia_san_pham") %></td>
									    <td><%=rs.getString("tinh_trang") %></td>
									    <td><%=rs.getString("tinh_nang") %></td>
									    <td><%=rs.getString("camera_truoc") %></td>
									    <td><%=rs.getString("camera_sau") %></td>
									    <td><%=rs.getString("dung_luong_pin") %></td>
									    <td><%=rs.getString("mau_sac") %></td>
									    <td><%=rs.getString("bao_mat") %></td>
			                            <td class="SX">
			                                <a href="DocCTSanPham?id=<%=rs.getString("ma_san_pham")%>">Sửa</a>
			                            </td>
			                            <td class="SX">
			                                <a href="#">Xóa</a>
			                            </td>
			                        </tr>
			 					 <%}%>
		                    </tbody>
		                </table>
		            </div>
		
		            <div class="pagination-bar">
		                <div class="container">
		                    <div class="pagination">
		                        <a href="#">&laquo;</a>
		                        <%for(int i=1; i<=tongSoTrang; i++){ %>				
		                            <a href="quan-ly-san-pham.jsp?trang=<%=i%>"><%= i %></a>
		                        <%}%>
		                        <a href="#">&raquo;</a>
		                    </div>
		                </div>
		            </div>
		
		            <div class="bt">
		                <a href="ThemSP.html" target="_blank">
		                    <input type="submit" value="Thêm sản phẩm" id="btthem" class="btThem">
		                </a>
		                <!--<input type="submit" value="Sửa sản phẩm" id="btxoa" class="btReset">-->
		            </div>
		        </div>
		    </div>
		
		    <!--<script>
		    var modal = document.getElementById('myModal');
		    var modal1 = document.getElementById('myModal1');
		    var bt = document.getElementById("btthem");
		    var btxoa = document.getElementById("btxoa");
		    var span = document.getElementsByClassName("close")[0];
		    var span1 = document.getElementsByClassName("close1")[0];
		
		
		    bt.onclick = function(){
		        modal.style.display = "block";
		    }
		
		    span.onclick = function(){
		        modal.style.display = "none";
		    }
		
		    window.onclick = function(){
		        if(event.target == modal){
		            modal.style.display = "none";
		        }
		        else if(event.target == modal1){
		            modal1.style.display = "none";
		        }
		    }
		
		    btxoa.onclick = function(){
		        modal1.style.display = "block";
		    }
		
		    span1.onclick = function(){
		        modal1.style.display = "none";
		    }
		
		
		
		
		    
		    </script>-->
		
		</body>
		</html>
	</c:if>
	<c:if test="${sessionScope.staff == null}">
		<h1> Chưa đăng nhập</h1>
		<a href="log-in-staff.jsp"> Tới trang đăng nhập </a> <br/>
	</c:if>
</c:if>
    
