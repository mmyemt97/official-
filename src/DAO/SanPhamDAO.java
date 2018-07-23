package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import DTO.SanPham;
import Database.Database;

public class SanPhamDAO {
	// doc cau lenh SQL: SELECT * FROM san_pham, đọc tất cả sản phẩm trong bảng.
	// luu tat ca ket qua vao` List SanPham.
	public static List<SanPham> DocTatCa(){
		List<SanPham> dsSanPham = null; // ban đầu chưa có sản phẩm, list là null
		// sau đó add kết quả vào list, thông qua lệnh dsSanPham.add();
		try {
			Connection db = Database.connect(); // kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Statement stm = db.createStatement(); // Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			
			ResultSet rs = stm.executeQuery("SELECT * FROM san_pham"); // ResultSet nhận kết quả excute từ statement
			dsSanPham = new ArrayList<>(); // new ArrayList của List Sản phẩm để lưu dữ liệu
			
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()){				
				SanPham sp = new SanPham(); // khởi tạo đối tượng SanPham để lưu từ rs 
				sp.setMa_san_pham(rs.getInt("ma_san_pham")); // lưu vào đối tượng sp, ứng với cột trong csdl
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				sp.setHinh_dai_dien(rs.getBlob("hinh_anh_mo_phong"));
				sp.setCamera_truoc(rs.getString("camera_truoc"));
				sp.setCamera_sau(rs.getString("camera_sau"));
				sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
				sp.setTinh_nang(rs.getString("tinh_nang"));
				sp.setBao_mat(rs.getString("bao_mat"));
				sp.setMau_sac(rs.getString("mau_sac"));
				
				dsSanPham.add(sp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsSanPham;
		
	}
}
