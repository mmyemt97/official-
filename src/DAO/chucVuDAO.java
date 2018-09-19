package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import DTO.chucVu;
import Database.Database;

public class chucVuDAO {
	//luu tat ca ket qua vao` List chucVu
	public static List<chucVu> danhSachChucVu(){
		//ban đầu chưa có chức vụ, list là null
		List<chucVu> dsChucVu = null;
		//Truyền câu truy vấn vào chuỗi sql
		String sql = "SELECT*FROM chuc_vu";
		try {
			//kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			//Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			//ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery(sql);
			//new ArrayList của List Sản phẩm để lưu dữ liệu
			dsChucVu = new ArrayList<>();
			//nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n)
			while(rs.next()) {
				//khởi tạo đối tượng chucVu để lưu từ rs
				chucVu cv = new chucVu();
				//lưu vào đối tượng cv, ứng với cột trong csdl
				cv.setMa_chuc_vu(rs.getInt("ma_chuc_vu"));
				cv.setChuc_vu(rs.getString("chuc_vu"));
				//Thực hiện việc thêm chức vụ
				dsChucVu.add(cv);
				
			}
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại dsChucVu
		return dsChucVu;
		
	}
	//đọc chức vụ
	//Tạo phương thức đọc chức vụ với đối số truyền vào là mã chức vụ
	public static chucVu docChucVu(int ma_chuc_vu) {
		//tạo biến cv  ban đầu là null
		chucVu cv = null;		
		
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			//Truyền vào chuổi sql bằng câu truy vấn
			String sql = "SELECT * FROM hethong_muaban.chuc_vu WHERE ma_chuc_vu = " + ma_chuc_vu;
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery(sql);
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n)
			while(rs.next()) {
				// khởi tạo đối tượng chucVu để lưu từ rs
				cv = new chucVu();
				// lưu vào đối tượng cv, ứng với cột trong csdl
				cv.setMa_chuc_vu(rs.getInt(0));
				cv.setChuc_vu(rs.getString(1));
			}
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại trạng thái chức vụ
		return cv;
	}
}
