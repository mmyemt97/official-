package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DTO.loaiThe;
import Database.Database;

public class loaiTheDAO {
	//luu tat ca ket qua vao` List loaiThe
	public static List<loaiThe> DocTatCa(){
		//ban đầu chưa có loại thẻ, list là null
		List<loaiThe> dsLoaiThe = null;
		
		
		try {
			//kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			//Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			//ResultSet nhận kết quả excute từ statement
			ResultSet rs= stm.executeQuery("SELECT * FROM loai_the");
			//new ArrayList của List Sản phẩm để lưu dữ liệu
			dsLoaiThe = new ArrayList<>();
			//nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while (rs.next()) {
				//khởi tạo đối tượng loaiThe để lưu từ rs 
				loaiThe lt = new loaiThe();
				//lưu vào đối tượng lt, ứng với cột trong csdl
				lt.setId_loai_the(rs.getInt("id_loai_the"));
				lt.setLoai_the(rs.getString("loai_the"));
				//Thực hiện việc thêm loại thẻ
				dsLoaiThe.add(lt);
			}
			
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại dsLoaiThe
		return dsLoaiThe;
	}
	//Tạo phương thức thêm loại thẻ mới
	public static int ThemLoaiTheMoi(loaiThe lt) {
		//Ban đầu trạng thái thêm là 0
		int them = 0;	
		
		try {
			//Kết nối database
			Connection db = Database.connect();
			//Truyền vào chuổi sql bằng câu truy vấn
			String sql = "INSERT INTO loai_the (`id_loai_the`, `loai_the`) VALUES (?, ?)";
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
			pst.setInt(1, lt.getId_loai_the());
			pst.setString(2, lt.getLoai_the());
			
			//Gọi trạng thái thêm để thực thi truy vấn
			them =  pst.executeUpdate();
			db.close();
			
			
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại trạng thái thêm
		return them;
	}
	
	//Đọc loại thẻ
	//Tạo phương thức Đọc loại thẻ
	public static loaiThe readLoaiThe(int maLoaiThe) {
		//tạo biến sp  ban đầu là null
		loaiThe lt = null;		
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			//Truyền vào chuổi sql bằng câu truy vấn
			String sql = "SELECT * FROM loai_the where id_loai_the = ?;";
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
			pst.setInt(1, maLoaiThe);
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = pst.executeQuery();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()) {
				// khởi tạo đối tượng loaiThe để lưu từ rs
				lt = new loaiThe();
				// lưu vào đối tượng lt, ứng với cột trong csdl
				lt.setId_loai_the(rs.getInt("id_loai_the"));
				lt.setLoai_the(rs.getString("loai_the"));
			}
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại trạng thái đọc loại thẻ
		return lt;
	}
}
