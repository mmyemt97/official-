package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import DTO.DonHang;
import Database.Database;

public class DonHangDAO {
	// luu tat ca ket qua vao` List DonHang
	public static List<DonHang> DocTatCa(){
		//ban đầu chưa có đơn hàng, list là null
		List<DonHang> dsDonHang = null;
		
		
		try {
			//kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			//Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			
			//ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("SELECT * FROM gio_hang");
			//new ArrayList của List Sản phẩm để lưu dữ liệu
			dsDonHang = new ArrayList<>();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()) 
			{
				//khởi tạo đối tượng DonHang để lưu từ rs 
				DonHang dh = new DonHang();
				//lưu vào đối tượng dh, ứng với cột trong csdl
				dh.setMa_don_hang(rs.getInt("idgio_hang"));
				dh.setMa_khach_hang(rs.getInt("iduser"));
				dh.setEmail(rs.getString("email"));
				dh.setHo_user(rs.getString("ho_user"));
				dh.setTen_user(rs.getString("ten_user"));
				dh.setSdt(rs.getInt("sdt"));
				dh.setDiaChi(rs.getString("diaChi"));
				dh.setPhuong(rs.getString("phuong"));
				dh.setQuan(rs.getString("quan"));
				dh.setChi_tiet(rs.getString("chi_tiet"));
				
				//Thực hiện việc thêm đơn hàng
				dsDonHang.add(dh);
			}
			
			
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Trả lại dsDonHang
		return dsDonHang;
	}
	
}
