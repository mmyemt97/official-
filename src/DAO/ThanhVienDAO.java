package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DTO.ThanhVien;
import Database.Database;

public class ThanhVienDAO {
	
	/*public static List<ThanhVien> DocTatCa(){
		List<ThanhVien> dsThanhVien = null;
		
		
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM user");
			dsThanhVien = new ArrayList<>();
			while(rs.next())
			{
				ThanhVien tv = new ThanhVien();
				tv.setIduser(rs.getInt("iduser"));
				tv.setUsername(rs.getString("username"));
				tv.setPassword(rs.getString("password"));
				tv.setHo_user(rs.getString("ho_user"));
				tv.setTen_user(rs.getString("ten_user"));
				tv.setSdt(rs.getInt("sdt"));
				tv.setEmail(rs.getString("email"));
				tv.setDia_chi(rs.getString("dia_chi"));
				tv.setQuan(rs.getString("quan"));
				tv.setPhuong(rs.getString("phuong"));
				tv.setThanh_pho(rs.getString("thanh_pho"));
				tv.setNuoc(rs.getString("nuoc"));
				tv.setZip_code(rs.getString("zip_code"));
				
				
				dsThanhVien.add(tv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return dsThanhVien;
	}*/
	
	
	//Đọc Tất Cả Thành Viên Mới
	// luu tat ca ket qua vao` List ThanhVien
	public static List<ThanhVien> DocTatCa(){
		List<ThanhVien> dsThanhVien = null;
		//ban đầu chưa có thành viên, list là null
		
		try {
			//Kết nối database
			Connection db = Database.connect();
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("SELECT iduser, username, password, ho_user, ten_user, sdt, email, dia_chi, quan, phuong, thanh_pho,\r\n" + 
					"nuoc, zip_code, diem, loai_the\r\n" + 
					"FROM user INNER JOIN the_tich_diem ON the_tich_diem.id_the_tich_diem = user.iduser\r\n" + 
					"INNER JOIN loai_the ON loai_the.id_loai_the = the_tich_diem.id_loai_the");
			// new ArrayList của List nhân viên để lưu dữ liệu
			dsThanhVien = new ArrayList<>();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next())
			{
				// khởi tạo đối tượng ThanhVien để lưu từ rs
				ThanhVien tv = new ThanhVien();
				// lưu vào đối tượng tv, ứng với cột trong csdl
				tv.setIduser(rs.getInt("iduser"));
				tv.setUsername(rs.getString("username"));
				tv.setPassword(rs.getString("password"));
				tv.setHo_user(rs.getString("ho_user"));
				tv.setTen_user(rs.getString("ten_user"));
				tv.setSdt(rs.getInt("sdt"));
				tv.setEmail(rs.getString("email"));
				tv.setDia_chi(rs.getString("dia_chi"));
				tv.setQuan(rs.getString("quan"));
				tv.setPhuong(rs.getString("phuong"));
				tv.setThanh_pho(rs.getString("thanh_pho"));
				tv.setNuoc(rs.getString("nuoc"));
				tv.setZip_code(rs.getString("zip_code"));
				tv.setDiem(rs.getInt("diem"));
				tv.setLoai_the(rs.getString("loai_the"));
				
				//Thực hiện thêm thành viên vào list
				dsThanhVien.add(tv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//Trả lại dsThanhVien
		return dsThanhVien;
	}
	
	
	//Chi tiết Thành Viên
	/*public static ThanhVien docTheoID(int id) {
		ThanhVien tv = null;
		Connection db = Database.connect();
		String sql = "SELECT * FROM user WHERE iduser =" + id;
		Statement stm;
		
		try {
			stm = db.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				tv = new ThanhVien();
				tv.setIduser(rs.getInt("iduser"));
				tv.setHo_user(rs.getString("ho_user"));
				tv.setTen_user(rs.getString("ten_user"));
				tv.setSdt(rs.getInt("sdt"));
				tv.setEmail(rs.getString("email"));
				tv.setDia_chi(rs.getString("dia_chi"));
				tv.setPhuong(rs.getString("phuong"));
				tv.setQuan(rs.getString("quan"));
				tv.setThanh_pho(rs.getString("thanh_pho"));
				tv.setNuoc(rs.getString("nuoc"));
				tv.setZip_code(rs.getString("zip_code"));
				tv.setUsername(rs.getString("username"));
				tv.setPassword(rs.getString("password"));	
			}db.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tv;
	}*/
	
	
	
	//Chi tiết thành viên mới
	//Tạo phương thức  đọc chi tiết thành viên mới
	public static ThanhVien docTheoID(int id) {
		//tạo biến tv  ban đầu là null
		ThanhVien tv = null;
		// kết nối với CSDL thông qua lớp Database ( khởi tạo)
		Connection db = Database.connect();
		//Truyền vào chuổi sql bằng câu truy vấn
		String sql = "SELECT `iduser`, `username`, `password`, `ho_user`, `ten_user`, `sdt`, `email`, `dia_chi`, `quan`, `phuong`, `thanh_pho`, `nuoc`, `zip_code`, `diem`, `loai_the`\r\n" + 
				"FROM user INNER JOIN the_tich_diem ON the_tich_diem.id_the_tich_diem = user.id_the_tich_diem \r\n" + 
				"INNER JOIN loai_the ON loai_the.id_loai_the = the_tich_diem.id_loai_the WHERE iduser = " + id;
		
		
		try {
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm;
			stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery(sql);
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()) {
				// khởi tạo đối tượng ThanhVien để lưu từ rs
				tv = new ThanhVien();
				// lưu vào đối tượng tv, ứng với cột trong csdl
				tv.setIduser(rs.getInt("iduser"));
				tv.setHo_user(rs.getString("ho_user"));
				tv.setTen_user(rs.getString("ten_user"));
				tv.setSdt(rs.getInt("sdt"));
				tv.setEmail(rs.getString("email"));
				tv.setDia_chi(rs.getString("dia_chi"));
				tv.setPhuong(rs.getString("phuong"));
				tv.setQuan(rs.getString("quan"));
				tv.setThanh_pho(rs.getString("thanh_pho"));
				tv.setNuoc(rs.getString("nuoc"));
				tv.setZip_code(rs.getString("zip_code"));
				tv.setUsername(rs.getString("username"));
				tv.setPassword(rs.getString("password"));	
				tv.setDiem(rs.getInt("diem"));
				tv.setLoai_the(rs.getString("loai_the"));
			}db.close();
			//Bắt trường hợp không kết nối được CSDL
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại trạng thái chi tiết thành viên
		return tv;
	}
	
	
	
	
	
	//Xóa Thành Viên
	//Tạo phương thức xóa Thành Viên với đối số truyền vào là iduser
	public static int XoaThanhVien(int iduser) {
		//Ban đầu trạng thái xóa là 0
		int xoa=0;
		try {
			//Kết nối database
			Connection db = Database.connect();
			//Truyền vào chuổi sql bằng câu truy vấn
			String sql = "DELETE FROM user where `iduser`=?";
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
			pst.setInt(1, iduser);
			
			//Gọi trạng thái thêm để thực thi truy vấn
			xoa = pst.executeUpdate();
		
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Trả lại trạng thái xóa
		return xoa;
	}
	
	

}
