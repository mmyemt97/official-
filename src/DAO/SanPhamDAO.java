package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import com.mysql.jdbc.Blob;
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
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
				String img = new String(b.getBytes(1l, (int) b.length()));
				sp.setHinh_anh(img);
				
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
	
	
	//Xóa Sản Phẩm
	public static int XoaSanPham(int ma_san_pham) {
		int xoa = 0;		
		try {
			Connection db = Database.connect();
			String sql = "DELETE FROM san_pham WHERE `ma_san_pham`= ?";
			PreparedStatement pst = db.prepareStatement(sql);
			pst.setInt(1, ma_san_pham);
			xoa = pst.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return xoa;		
	}
	
	
	//Sửa Sản Phẩm
	public static int SuaSanPham(int ma_san_pham, String ten_san_pham, int gia_san_pham, String tinh_trang, String camera_truoc, String camera_sau, String dung_luong_pin,
			String tinh_nang, String bao_mat, String mau_sac) {
		int sua = 0;
		
		try {
			Connection db = Database.connect();
			String sql = "UPDATE san_pham SET `ten_san_pham`=?, `gia_san_pham`=?,"
					+ "`tinh_trang` = ?,"
					+ " `camera_truoc`=?, `camera_sau`=?, `dung_luong_pin`=?,"
					+ " `tinh_nang`=?, `bao_mat`=?, `mau_sac`=? WHERE `ma_san_pham`=?";
			PreparedStatement pst = db.prepareStatement(sql);
			pst.setString(1, ten_san_pham);
			pst.setInt(2, gia_san_pham);
			pst.setString(3, tinh_trang);
			//pst.setBlob(4, hinh_anh_mo_phong);
			pst.setString(4, camera_truoc);
			pst.setString(5, camera_sau);
			pst.setString(6, dung_luong_pin);
			pst.setString(7, tinh_nang);
			pst.setString(8, bao_mat);
			pst.setString(9, mau_sac);
			pst.setInt(10, ma_san_pham);
			
			sua = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sua;
	}
	
	
	//Thêm Sản Phẩm
	public static int Them(SanPham sp) {
		int status = 0;
		Connection db = Database.connect();
		try {
			String sql = "INSERT INTO san_pham (`ma_san_pham`,`ten_san_pham`, `hang_san_xuat`, `gia_san_pham`, `tinh_trang`, `hinh_anh_mo_phong`, `camera_truoc`, `camera_sau`, `dung_luong_pin`, `tinh_nang`, `bao_mat`, `mau_sac`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			
			pst.setInt(1, sp.getMa_san_pham());
			pst.setString(2, sp.getTenSanPham());
			pst.setString(3, sp.getHangSanXuat());
			pst.setInt(4, sp.getGiaSanPham());
			pst.setString(5, sp.getTinhTrang());
			pst.setBlob(6, sp.getHinh_dai_dien());
			pst.setString(7, sp.getCamera_truoc());
			pst.setString(8, sp.getCamera_sau());
			pst.setString(9, sp.getDung_luong_pin());
			pst.setString(10, sp.getTinh_nang());
			pst.setString(11, sp.getBao_mat());
			pst.setString(12, sp.getMau_sac());
			
			status = pst.executeUpdate();
			db.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}

	
	//Chi Tiết Sản Phẩm DAO
	public static SanPham docTheoID(int id) {
		SanPham sp = null;
		Connection db = Database.connect();
		String sql = "SELECT * FROM san_pham WHERE ma_san_pham =" + id;
		Statement stm;
		
		try {
			stm = db.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				// tạo 1 biến kiểu Blob, nhận giá trị từ CSDL về dạng BLob
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
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
				sp.setHinh_anh(base64Image);
				
				sp.setCamera_truoc(rs.getString("camera_truoc"));
				sp.setCamera_sau(rs.getString("camera_sau"));
				sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
				sp.setTinh_nang(rs.getString("tinh_nang"));
				sp.setBao_mat(rs.getString("bao_mat"));
				sp.setMau_sac(rs.getString("mau_sac")); 
			}
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sp;
	}
	
	
	//Tìm SP theo Tên
	public static List<SanPham> timTheoTen(String tenSanPhamCanTim){
		List<SanPham> dsSanPham = null;
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select * from  san_pham where ten_san_pham like '%"+tenSanPhamCanTim+"%'");
			dsSanPham = new ArrayList<>();
			while(rs.next()){
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
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
				sp.setHinh_anh(base64Image);
				
				sp.setCamera_truoc(rs.getString("camera_truoc"));
				sp.setCamera_sau(rs.getString("camera_sau"));
				sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
				sp.setTinh_nang(rs.getString("tinh_nang"));
				sp.setBao_mat(rs.getString("bao_mat"));
				sp.setMau_sac(rs.getString("mau_sac"));
				dsSanPham.add(sp);
			}
			db.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsSanPham;
		
	}
	
	
	//
	
	

}
