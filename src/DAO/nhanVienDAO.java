package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DTO.nhanVien;
import Database.Database;

public class nhanVienDAO {
	// luu tat ca ket qua vao` List nhan vien
	public static List<nhanVien> DocTatCa(){
		List<nhanVien> dsNhanVien = null; //ban đầu chưa có gì, list là null
		// sau đó add kết quả vào list, thông qua lệnh dsNhanVien.add();
		
		
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("SELECT * FROM nhan_vien INNER JOIN chuc_vu ON nhan_vien.ma_chuc_vu = chuc_vu.ma_chuc_vu order by idnhan_vien asc");
			// new ArrayList của List nhân viên để lưu dữ liệu
			dsNhanVien = new ArrayList<>();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()) {
				
				// khởi tạo đối tượng nhanVien để lưu từ rs
				nhanVien nv = new nhanVien();
				// lưu vào đối tượng nv, ứng với cột trong csdl
				nv.setIdnhan_vien(rs.getInt("idnhan_vien"));
				nv.setUsername(rs.getString("username"));
				nv.setPassword(rs.getString("password"));
				nv.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nv.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				
				nv.setChuc_vu(rs.getString("chuc_vu"));
				nv.setEmail(rs.getString("email"));
				nv.setSdt(rs.getInt("sdt"));
				
				dsNhanVien.add(nv);
			}
			
		//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		//Trả lại dsNhanVien
		return dsNhanVien;
	}
	
	
	//Xóa Nhân Viên
	//Tạo phương thức xóa sản phẩm với đối số truyền vào là idnhan_vien
	public static int XoaNhanVien(int idnhan_vien) {
		//Ban đầu trạng thái xóa là 0
		int xoa = 0;
		try {
			//Kết nối database
			Connection db = Database.connect();
			//Truyền vào chuổi sql bằng câu truy vấn 
			String sql = "DELETE FROM nhan_vien WHERE `idnhan_vien`= ?";
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
			pst.setInt(1, idnhan_vien);
			//Gọi trạng thái xóa để thực thi truy vấn
			xoa = pst.executeUpdate();
			
		//Bắt trường hợp không kết nối được CSDL	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Trả lại trạng thái xóa
		return xoa;
	}
	
	
	//Đăng Ký Nhân Viên
	//Tạo phương thức Đăng Ký Nhân Viên
	public static int dangKyNhanVien(nhanVien nv) {
		//Ban đầu trạng thái xóa là 0
		int status =0;
		//Truyền vào chuổi sql bằng câu truy vấn
		String sql = "INSERT INTO `hthong_muaban`.`nhan_vien` (`username`, `password`, `ho_nhan_vien`, `ten_nhan_vien`,`email` ,`sdt`) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			//Kết nối database
			Connection db = Database.connect();
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
			pst.setString(1, nv.getUsername());
			pst.setString(2, nv.getPassword());
			pst.setString(3, nv.getHo_nhan_vien());
			pst.setString(4, nv.getTen_nhan_vien());
			pst.setString(5, nv.getEmail());
			pst.setInt(6, nv.getSdt());
			//Gọi trạng thái thêm để thực thi truy vấn
			status = pst.executeUpdate();
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//Trả lại trạng thái thêm
		return status;
	}
	
	
	
	//Đăng Nhập
	//Tạo phương thức Đăng Nhập với đối số truyền vào là username và password
	public static nhanVien docTheoUsernamePassword(String username, String password) {
		//tạo biến nv_dangnhap  ban đầu là null
		nhanVien nv_dangnhap = null;
		
		try {
			//Truyền vào chuổi sql bằng câu truy vấn
			String sql = "select*from nhan_vien where username = ? and password = ? ";
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
			pst.setString(1, username);
			pst.setString(2, password);
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = pst.executeQuery();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()) {
				// khởi tạo đối tượng nhanVien để lưu từ rs
				nv_dangnhap = new nhanVien();
				// lưu vào đối tượng nv_dangnhap, ứng với cột trong csdl
				nv_dangnhap.setIdnhan_vien(rs.getInt("idnhan_vien"));
				nv_dangnhap.setUsername(rs.getString("username"));
				nv_dangnhap.setPassword(rs.getString("password"));
				nv_dangnhap.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nv_dangnhap.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				nv_dangnhap.setEmail(rs.getString("email"));
				nv_dangnhap.setSdt(rs.getInt("sdt"));
				nv_dangnhap.setMa_chuc_vu(rs.getInt("ma_chuc_vu"));
			}
			/* lỗi SQL Injection cú pháp: ' or '1' = '1'
			 * Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select*from nhan_vien where username = '"+username+"' and password = '"+password+"' ");
			 where pass = ' 
			while(rs.next()) {
				nv_dangnhap = new nhanVien();
				nv_dangnhap.setUsername(rs.getString("username"));
				nv_dangnhap.setPassword(rs.getString("password"));
				nv_dangnhap.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nv_dangnhap.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				nv_dangnhap.setEmail(rs.getString("email"));
				nv_dangnhap.setSdt(rs.getInt("sdt"));
			}*/
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại trạng thái đăng nhập
		return nv_dangnhap;
	}
	
	
	//Reset Password
	//Tạo phương thức Reset Password với đối số truyền vào là username và password
	public static nhanVien ResetPassword(String username, String email) {
		//tạo biến nhanVienQuenMatKhau ban đầu là null
		nhanVien nhanVienQuenMatKhau = null;
		//Kết nối database
		Connection db = Database.connect();
		// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
		Statement stm;
		
		try {
			
			stm = db.createStatement();
			//Truyền vào chuổi sql bằng câu truy vấn
			String sql = "SELECT * FROM hthong_muaban.nhan_vien where username = '"+username+"' and email = '"+email+"' ";
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery(sql);
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()) {
				
				// khởi tạo đối tượng nhanVien để lưu từ rs
				nhanVienQuenMatKhau = new nhanVien();
				// lưu vào đối tượng nhanVienQuenMatKhau, ứng với cột trong csdl
				nhanVienQuenMatKhau.setUsername(rs.getString("username"));
				nhanVienQuenMatKhau.setPassword(rs.getString("password"));
				nhanVienQuenMatKhau.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nhanVienQuenMatKhau.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				nhanVienQuenMatKhau.setEmail(rs.getString("email"));
				nhanVienQuenMatKhau.setSdt(rs.getInt("sdt"));
			}
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Trả lại trạng thái nhanVienQuenMatKhau
		return nhanVienQuenMatKhau;		
	}
	
	
	//Thêm Nhân Viên
	//Tạo phương thức thêm Nhân Viên mới
	public static int Them(nhanVien nv) {
		//Ban đầu trạng thái xóa là 0
		int status = 0;
		//Kết nối database
		Connection db = Database.connect();
		try {
			//Truyền vào chuổi sql bằng câu truy vấn
			String sql = "INSERT INTO nhan_vien (`idnhan_vien`, username, password, `ho_nhan_vien`, `ten_nhan_vien`, email, sdt,`hinh_nhan_vien`, `ma_chuc_vu`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
			pst.setInt(1, nv.getIdnhan_vien());
			pst.setString(2, nv.getUsername());
			pst.setString(3, nv.getPassword());
			pst.setString(4, nv.getHo_nhan_vien());
			pst.setString(5, nv.getTen_nhan_vien());
			pst.setString(6, nv.getEmail());
			pst.setInt(7, nv.getSdt());
			pst.setBlob(8, nv.getHinh_nhan_vien());
			pst.setInt(9, nv.getMa_chuc_vu());
			
			//Gọi trạng thái thêm để thực thi truy vấn
			status = pst.executeUpdate();
			db.close();
			//Bắt trường hợp không kết nối được CSDL	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Trả lại trạng thái thêm
		return status;
	}
	
	
	//Chi Tiết Nhân Viên
	//Tạo phương thức Chi Tiết Nhân Viên
	public static nhanVien docTheoID(int id){
		//tạo biến nv  ban đầu là null
		nhanVien nv = null;
		
		
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			//Truyền vào chuổi sql bằng câu truy vấn
			String sql = "SELECT * FROM nhan_vien INNER JOIN chuc_vu ON nhan_vien.ma_chuc_vu = chuc_vu.ma_chuc_vu where idnhan_vien ="+id;
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm;
			stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery(sql);
			
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()) {
				// khởi tạo đối tượng nhanVien để lưu từ rs
				nv = new nhanVien();
				// lưu vào đối tượng nv, ứng với cột trong csdl
				nv.setIdnhan_vien(rs.getInt("idnhan_vien"));
				nv.setUsername(rs.getString("username"));
				nv.setPassword(rs.getString("password"));
				nv.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nv.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				nv.setMa_chuc_vu(rs.getInt("ma_chuc_vu"));
				nv.setEmail(rs.getString("email"));
				nv.setSdt(rs.getInt("sdt"));
				nv.setChuc_vu(rs.getString("chuc_vu"));
				
				// tạo 1 biến kiểu Blob, nhận giá trị từ CSDL về dạng BLob
				Blob b = (Blob) rs.getBlob("hinh_nhan_vien");
				// Tách biến blob, ra thành kiểu nhị phân ( InputStream)
				InputStream inputStream = (InputStream) b.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				 
				// duyệt qua mảng kiểu byte sau khi lưu ở nhị phân, 
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					// mỗi lần duyệt là lưu vào outStream để lát in ra hình ảnh
				    outputStream.write(buffer, 0, bytesRead);
				}
				 
				// tạo mảng bytes sau khi duyệt và lưu trong outputstream
				byte[] imageBytes = outputStream.toByteArray();
				 
				// ép kiểu từ byte về lại String, do là dạng base64, 
				// nên ở thẻ img, phải khai báo data có kiểu là base64
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				 
				inputStream.close();
				outputStream.close();
				nv.setHinh_anh(base64Image);
	
			}
			db.close();
			
			
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Bắt trường hợp không đọc được hình
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//Trả lại trạng thái chi tiết nhân viên
		return nv;
	}
	
	
	//Sửa Nhân Viên
	//Tạo phương thức Sửa Nhân Viên
	public static int SuaNhanVien(int idnhan_vien, String username, String password, String ho_nhan_vien, String ten_nhan_vien, String email, int sdt, int ma_chuc_vu) {
		//Ban đầu trạng thái xóa là 0
		int sua = 0;
		try {
			//Kết nối database
			Connection db = Database.connect();
			//Truyền vào chuổi sql bằng câu truy vấn
			String sql = "UPDATE nhan_vien SET `username`=?, `password`=?,"
					+ "`ho_nhan_vien` = ?,"
					+ " `ten_nhan_vien`=?, `email`=?, `sdt`=?,"
					+ " `ma_chuc_vu`=? WHERE `idnhan_vien`=?";
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, ho_nhan_vien);
			pst.setString(4, ten_nhan_vien);
			pst.setString(5, email);
			pst.setInt(6, sdt);
			pst.setInt(7, ma_chuc_vu);
			pst.setInt(8, idnhan_vien);
			//Gọi trạng thái sửa để thực thi truy vấn
			sua = pst.executeUpdate();
			
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại trạng thái sửa
		return sua;
	}
	
	
	
}
