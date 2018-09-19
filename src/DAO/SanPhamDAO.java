package DAO;
//Import thư viện jdbc, list,...
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
	//luu tat ca ket qua vao` List SanPham.
	public static List<SanPham> DocTatCa(){
		List<SanPham> dsSanPham = null; //ban đầu chưa có sản phẩm, list là null
		// sau đó add kết quả vào list, thông qua lệnh dsSanPham.add();
		try {
			Connection db = Database.connect(); //kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Statement stm = db.createStatement(); //Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			
			ResultSet rs = stm.executeQuery("SELECT * FROM san_pham"); //ResultSet nhận kết quả excute từ statement
			dsSanPham = new ArrayList<>(); //new ArrayList của List Sản phẩm để lưu dữ liệu
			
			//nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()){				
				SanPham sp = new SanPham(); //khởi tạo đối tượng SanPham để lưu từ rs 
				sp.setMa_san_pham(rs.getInt("ma_san_pham")); //lưu vào đối tượng sp, ứng với cột trong csdl
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
				
				//Thực hiện việc thêm sản phẩm
				dsSanPham.add(sp);
				
			}
			
		//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		//Trả lại dsSanPham
		return dsSanPham;
		
	}
	
	
	//Xóa Sản Phẩm
	//Tạo phương thức xóa sản phẩm với đối số truyền vào là mã sản phẩm
	public static int XoaSanPham(int ma_san_pham) {
		//Ban đầu trạng thái xóa là 0
		int xoa = 0;		
		try {
			//Kết nối database
			Connection db = Database.connect();
			//Truyền vào chuổi sql bằng câu truy vấn 
			String sql = "DELETE FROM san_pham WHERE `ma_san_pham`= ?";
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
			pst.setInt(1, ma_san_pham);
			//Gọi trạng thái xóa để thực thi truy vấn
			xoa = pst.executeUpdate();			
		} 
		//Bắt trường hợp không kết nối được CSDL
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Trả lại trạng thái xóa
		return xoa;		
	}
	
	
	//Sửa Sản Phẩm
	//Tạo phương thức sửa sản phẩm với nhiều đối số truyền vào
	public static int SuaSanPham(int ma_san_pham, String ten_san_pham, int gia_san_pham, String tinh_trang, String camera_truoc, String camera_sau, String dung_luong_pin,
			String tinh_nang, String bao_mat, String mau_sac) {
		//Ban đầu trạng thái xóa là 0
		int sua = 0;
		
		try {
			//Kết nối database
			Connection db = Database.connect();
			//Truyền vào chuổi sql bằng câu truy vấn 
			String sql = "UPDATE san_pham SET `ten_san_pham`=?, `gia_san_pham`=?,"
					+ "`tinh_trang` = ?,"
					+ " `camera_truoc`=?, `camera_sau`=?, `dung_luong_pin`=?,"
					+ " `tinh_nang`=?, `bao_mat`=?, `mau_sac`=? WHERE `ma_san_pham`=?";
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
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
	
	
	//Thêm Sản Phẩm
	//Tạo phương thức thêm sản phẩm mới
	public static int Them(SanPham sp) {
		//Ban đầu trạng thái theêm là 0
		int status = 0;
		//Kết nối database
		Connection db = Database.connect();
		try {
			//Truyền vào chuổi sql bằng câu truy vấn
			String sql = "INSERT INTO san_pham (`ma_san_pham`,`ten_san_pham`, `hang_san_xuat`, `gia_san_pham`, `tinh_trang`, `hinh_anh_mo_phong`, `camera_truoc`, `camera_sau`, `dung_luong_pin`, `tinh_nang`, `bao_mat`, `mau_sac`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			//Tạo 1 đối tượng PreparedStatement để ngăn ngừa SQL injection
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			//Gán giá trị mã sản phẩm vào dấu chấm hỏi trong PreparedStatement
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
			//Gọi trạng thái thêm để thực thi truy vấn
			status = pst.executeUpdate();
			//đóng csdl
			db.close();
		//Bắt trường hợp không kết nối được CSDL	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Trả lại trạng thái thêm
		return status;
	}

	
	//Chi Tiết Sản Phẩm DAO
	//Tạo phương thức đọc sản phẩm với đối số truyền vào là id
	public static SanPham docTheoID(int id) {
		//tạo biến sp  ban đầu là null
		SanPham sp = null;
		// kết nối với CSDL thông qua lớp Database ( khởi tạo)
		Connection db = Database.connect();
		//Truyền vào chuổi sql bằng câu truy vấn
		String sql = "SELECT * FROM san_pham WHERE ma_san_pham =" + id;
		// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
		Statement stm;
		
		try {
			stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery(sql);
			
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()) {
				
				// khởi tạo đối tượng SanPham để lưu từ rs
				sp = new SanPham();
				// lưu vào đối tượng sp, ứng với cột trong csdl
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				// tạo 1 biến kiểu Blob, nhận giá trị từ CSDL về dạng BLob
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				// Tách biến blob, ra thành kiểu nhị phân ( InputStream)
				InputStream inputStream = (InputStream) b.getBinaryStream();
				//Tạo mới 1 mãng kiểu giá trị là byte để in ra màn hình kết quả sau khi ép kiểu
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				//Tạo mới 1 mãng kiểu giá trị là byte để đọc giá trị inputStream sau khi đã tách thành kiểu nhị phân
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				 
				// duyệt qua mảng kiểu byte sau khi lưu ở nhị phân, 
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					// mỗi lần duyệt là lưu vào outStream để in ra hình ảnh
				    outputStream.write(buffer, 0, bytesRead);
				}
				 
				// tạo mảng bytes sau khi duyệt và lưu trong outputstream
				byte[] imageBytes = outputStream.toByteArray();
				 
				// ép kiểu từ byte về lại String, do là dạng base64, 
				// nên ở thẻ img, phải khai báo data có kiểu là base64
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
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
			
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Bắt trường hợp không đọc được hình
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Trả lại trạng thái chi tiết sản phẩm
		return sp;
	}
	
	
	//Tìm SP theo Tên
	// luu ket qua tìm được theo tên vao` List
	public static List<SanPham> timTheoTen(String tenSanPhamCanTim){
		// ban đầu chưa có sản phẩm, list là null
		List<SanPham> dsSanPham = null;
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("select * from  san_pham where ten_san_pham like '%"+tenSanPhamCanTim+"%'");
			// new ArrayList của List nhân viên để lưu dữ liệu
			dsSanPham = new ArrayList<>();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()){
				// khởi tạo đối tượng SanPham để lưu từ rs
				SanPham sp = new SanPham();
				// lưu vào đối tượng sp, ứng với cột trong csdl
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
				 
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
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
			
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			
			e.printStackTrace();
			//Bắt trường hợp không đọc được hình 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Trả lại dsSanPham
		return dsSanPham;
		
	}
	
	
	//Tìm SP Theo Hãng
	// luu ket qua tìm được theo tên vao` List
	public static List<SanPham> timKiemTheoHang(String hang_sxuat){
		// ban đầu chưa có sản phẩm, list là null
		List<SanPham> dsSanPham = null;
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("select * from san_pham where hang_san_xuat like '%"+hang_sxuat+"%'");
			// new ArrayList của List nhân viên để lưu dữ liệu
			dsSanPham = new ArrayList<>();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()){
				// khởi tạo đối tượng SanPham để lưu từ rs
				SanPham sp = new SanPham();
				// lưu vào đối tượng sp, ứng với cột trong csdl
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
				 
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
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
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			
			e.printStackTrace();
			//Bắt trường hợp không đọc được hình
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại dsSanPham
		return dsSanPham;	
	}
	
	
	//Sản Phẩm Dưới 1 triệu
	// luu ket qua sản phẩm dưới 1 triệu vao` List
	public static List<SanPham> timTheoGiaDuoi1Trieu(){
		// ban đầu chưa có gì, list là null
		// sau đó add kết quả vào list
		List<SanPham> dsSanPham = null;
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("select * from san_pham where gia_san_pham <1000000");
			// new ArrayList của List nhân viên để lưu dữ liệu
			dsSanPham = new ArrayList<>();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 			
			while(rs.next()){
				// khởi tạo đối tượng SanPham để lưu từ rs
				SanPham sp = new SanPham();
				// lưu vào đối tượng sp, ứng với cột trong csdl
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
				 
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
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
			
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			
			e.printStackTrace();
			//Bắt trường hợp không đọc được hình
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại dsSanPham
		return dsSanPham;
	}
	
	
	//Sản phẩm từ 1 đến 3 triệu
	// luu ket qua sản phẩm từ 1 - 3 triệu vao` List
	public static List<SanPham> timTheoGia1TrieuDen3Trieu(){
		// ban đầu chưa có gì, list là null
		// sau đó add kết quả vào list
		List<SanPham> dsSanPham = null;
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("select * from san_pham where gia_san_pham >=1000000 and gia_san_pham <3000000 ");
			// new ArrayList của List nhân viên để lưu dữ liệu
			dsSanPham = new ArrayList<>();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
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
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
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
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			
			e.printStackTrace();
			//Bắt trường hợp không đọc được hình
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại dsSanPham
		return dsSanPham;
	}
	
	
	//Sản phẩm từ 3 đến 7 triệu
	// luu ket qua sản phẩm từ 3 đến 7 triệu vao` List
	public static List<SanPham> timTheoGia3TrieuDen7Trieu(){
		List<SanPham> dsSanPham = null;
		// ban đầu chưa có gì, list là null
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("select * from san_pham where gia_san_pham >=3000000 and gia_san_pham <7000000 ");
			// new ArrayList của List nhân viên để lưu dữ liệu
			dsSanPham = new ArrayList<>();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()){
				// khởi tạo đối tượng SanPham để lưu từ rs
				SanPham sp = new SanPham();
				// lưu vào đối tượng sp, ứng với cột trong csdl
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
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
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
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			
			e.printStackTrace();
			//Bắt trường hợp không đọc được hình
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại dsSanPham
		return dsSanPham;
		
	}
	
	
	//Sản phẩm từ 7 đến 10 triệu
	// luu ket qua sản phẩm từ 7 đến 10 triệu vao` List
	public static List<SanPham> timTheoGia7TrieuDen10Trieu(){
		List<SanPham> dsSanPham = null;
		// ban đầu chưa có gì, list là null
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("select * from san_pham where gia_san_pham >=7000000 and gia_san_pham <10000000 ");
			// new ArrayList của List nhân viên để lưu dữ liệu
			dsSanPham = new ArrayList<>();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()){
				// khởi tạo đối tượng SanPham để lưu từ rs
				SanPham sp = new SanPham();
				// lưu vào đối tượng sp, ứng với cột trong csdl
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
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
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
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			
			e.printStackTrace();
			//Bắt trường hợp không đọc được hình
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại dsSanPham
		return dsSanPham;
		
	}
	
	
	//Sản phẩm trên 10 triệu
	// luu ket qua sản phẩm trên 10 triệu vao` List
	public static List<SanPham> timTheoGiaTren10Trieu(){
		//ban đầu chưa có gì, list là null
		List<SanPham> dsSanPham = null;
		try {
			// kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			// Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			// ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("select * from san_pham where gia_san_pham >=10000000");
			// new ArrayList của List nhân viên để lưu dữ liệu
			dsSanPham = new ArrayList<>();
			// nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()){
				// khởi tạo đối tượng SanPham để lưu từ rs
				SanPham sp = new SanPham();
				// lưu vào đối tượng sp, ứng với cột trong csdl
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
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
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
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			
			e.printStackTrace();
			//Bắt trường hợp không đọc được hình
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Trả lại dsSanPham
		return dsSanPham;
		
	}
	
	
	//Tìm theo hãng và dưới 1 triệu
	// luu ket qua sản phẩm Tìm theo hãng và dưới 1 triệu vao` List
	public static List<SanPham> timTheoHangGiaDuoi1Trieu(String brand){
        List<SanPham> listDuoi1Trieu = new ArrayList<SanPham>();
        //ban đầu chưa có gì, list là null
        try {
        	// kết nối với CSDL thông qua lớp Database ( khởi tạo)
            Connection db = Database.connect();
            // Truyền câu truy vấn vào chuỗi sql
            String sql = "SELECT * FROM san_pham where hang_san_xuat like N'%"+brand+"%' and gia_san_pham <=1000000;";
         // Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
            Statement stm = db.createStatement();
         // ResultSet nhận kết quả excute từ statement
            ResultSet rs = stm.executeQuery(sql);
         // nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
            while(rs.next()) {
            	// khởi tạo đối tượng SanPham để lưu từ rs
                SanPham sp = new SanPham();
             // lưu vào đối tượng sp, ứng với cột trong csdl
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
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
				inputStream.close();
				outputStream.close();
				sp.setHinh_anh(base64Image);
                sp.setCamera_truoc(rs.getString("camera_truoc"));
                sp.setCamera_sau(rs.getString("camera_sau"));
                sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
                sp.setTinh_nang(rs.getString("tinh_nang"));
                sp.setBao_mat(rs.getString("bao_mat"));
                sp.setMau_sac(rs.getString("mau_sac"));
                listDuoi1Trieu.add(sp);

            }
            db.close();
        }
        catch (SQLException e) {
        	//Bắt trường hợp không kết nối được CSDL
            // TODO Auto-generated catch block
            e.printStackTrace();
          //Bắt trường hợp không đọc được hình
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
      //Trả lại listDuoi1Trieu
        return listDuoi1Trieu;
    }
	
	
	//Tìm sản phẩm hãng giá 1-3 triệu
	// luu ket qua sản phẩm Tìm sản phẩm hãng giá 1-3 triệu vao` List
	public static List<SanPham> timTheoHangGia1Den3Trieu(String brand){
        List<SanPham> list1Den3Trieu = new ArrayList<SanPham>();
      //ban đầu chưa có gì, list là null
        try {
        	// kết nối với CSDL thông qua lớp Database ( khởi tạo)
            Connection db = Database.connect();
            //Truyền câu truy vấn vào chuỗi sql
            String sql = "SELECT * FROM san_pham where hang_san_xuat like N'%"+brand+"%' and gia_san_pham >=1000000 and gia_san_pham <= 3000000;";
         // Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
            Statement stm = db.createStatement();
         // ResultSet nhận kết quả excute từ statement
            ResultSet rs = stm.executeQuery(sql);
         // nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
            while(rs.next()) {
            	// khởi tạo đối tượng SanPham để lưu từ rs
                SanPham sp = new SanPham();
             // lưu vào đối tượng sp, ứng với cột trong csdl
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
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
				inputStream.close();
				outputStream.close();
				sp.setHinh_anh(base64Image);
                sp.setCamera_truoc(rs.getString("camera_truoc"));
                sp.setCamera_sau(rs.getString("camera_sau"));
                sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
                sp.setTinh_nang(rs.getString("tinh_nang"));
                sp.setBao_mat(rs.getString("bao_mat"));
                sp.setMau_sac(rs.getString("mau_sac"));
                list1Den3Trieu.add(sp);

            }
            db.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          //Bắt trường hợp không đọc được hình
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //list1Den3Trieu
        return list1Den3Trieu;
    }
	
	
	//Tìm sp hãng giá 3-7 triệu
	// luu ket qua sản phẩm Tìm sản phẩm hãng giá 3-7 triệu vao` List
	public static List<SanPham> timTheoHangGia3Den7rieu(String brand){
        List<SanPham> list3Den7Trieu = new ArrayList<SanPham>();
      //ban đầu chưa có gì, list là null
        try {
        	// kết nối với CSDL thông qua lớp Database ( khởi tạo)
            Connection db = Database.connect();
          //Truyền câu truy vấn vào chuỗi sql
            String sql = "SELECT * FROM san_pham where hang_san_xuat like N'%"+brand+"%' and gia_san_pham >=3000000 and gia_san_pham <= 7000000;";
         // Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
            Statement stm = db.createStatement();
         // ResultSet nhận kết quả excute từ statement
            ResultSet rs = stm.executeQuery(sql);
         // nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
            while(rs.next()) {
            	// khởi tạo đối tượng SanPham để lưu từ rs
                SanPham sp = new SanPham();
             // lưu vào đối tượng sp, ứng với cột trong csdl
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
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
				inputStream.close();
				outputStream.close();
				sp.setHinh_anh(base64Image);
                sp.setCamera_truoc(rs.getString("camera_truoc"));
                sp.setCamera_sau(rs.getString("camera_sau"));
                sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
                sp.setTinh_nang(rs.getString("tinh_nang"));
                sp.setBao_mat(rs.getString("bao_mat"));
                sp.setMau_sac(rs.getString("mau_sac"));
                list3Den7Trieu.add(sp);

            }
            db.close();
        }
      //Bắt trường hợp không kết nối được CSDL
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          //Bắt trường hợp không đọc được hình
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //list3Den7Trieu
        return list3Den7Trieu;
    }
	
	
	//Tìm sp hãng giá 7-10 triệu
	// luu ket qua sản phẩm Tìm sản phẩm hãng giá 7-10 triệu vao` List
	public static List<SanPham> timTheoHangGia7Den10rieu(String brand){
		//ban đầu chưa có gì, list là null
        List<SanPham> list7Den10Trieu = new ArrayList<SanPham>();
        
        try {
        	// kết nối với CSDL thông qua lớp Database ( khởi tạo)
            Connection db = Database.connect();
          //Truyền câu truy vấn vào chuỗi sql
            String sql = "SELECT * FROM san_pham where hang_san_xuat like N'%"+brand+"%' and gia_san_pham >=7000000 and gia_san_pham <= 10000000;";
         // Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
            Statement stm = db.createStatement();
         // ResultSet nhận kết quả excute từ statement
            ResultSet rs = stm.executeQuery(sql);
         // nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
            while(rs.next()) {
            	// khởi tạo đối tượng SanPham để lưu từ rs
                SanPham sp = new SanPham();
             // lưu vào đối tượng sp, ứng với cột trong csdl
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
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
				inputStream.close();
				outputStream.close();
				sp.setHinh_anh(base64Image);
                sp.setCamera_truoc(rs.getString("camera_truoc"));
                sp.setCamera_sau(rs.getString("camera_sau"));
                sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
                sp.setTinh_nang(rs.getString("tinh_nang"));
                sp.setBao_mat(rs.getString("bao_mat"));
                sp.setMau_sac(rs.getString("mau_sac"));
                list7Den10Trieu.add(sp);

            }
            db.close();
        }
      //Bắt trường hợp không kết nối được CSDL
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          //Bắt trường hợp không đọc được hình
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //list7Den10Trieu
        return list7Den10Trieu;
    }
	
	
	
	//Tìm sp hãng giá trên 10 triệu
	// luu ket qua sản phẩm Tìm sản phẩm hãng giá trên 10 triệu vao` List
	public static List<SanPham> timTheoHangGiaTren10Trieu(String brand){
		//ban đầu chưa có gì, list là null
        List<SanPham> listTren10Trieu = new ArrayList<SanPham>();
        try {
        	// kết nối với CSDL thông qua lớp Database ( khởi tạo)
            Connection db = Database.connect();
          //Truyền câu truy vấn vào chuỗi sql
            String sql = "SELECT * FROM san_pham where hang_san_xuat like N'%"+brand+"%' and gia_san_pham >=10000000;";
         // Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
            Statement stm = db.createStatement();
         // ResultSet nhận kết quả excute từ statement
            ResultSet rs = stm.executeQuery(sql);
         // nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
            while(rs.next()) {
            	// khởi tạo đối tượng SanPham để lưu từ rs
                SanPham sp = new SanPham();
             // lưu vào đối tượng sp, ứng với cột trong csdl
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
				 
				//Sau khi thực hiện thành công sẽ đóng luồng xử lí lại
				inputStream.close();
				outputStream.close();
				sp.setHinh_anh(base64Image);
                sp.setCamera_truoc(rs.getString("camera_truoc"));
                sp.setCamera_sau(rs.getString("camera_sau"));
                sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
                sp.setTinh_nang(rs.getString("tinh_nang"));
                sp.setBao_mat(rs.getString("bao_mat"));
                sp.setMau_sac(rs.getString("mau_sac"));
                listTren10Trieu.add(sp);

            }
            db.close();
        }
      //Bắt trường hợp không kết nối được CSDL
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          //Bắt trường hợp không đọc được hình
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Trả lại listTren10Trieu
        return listTren10Trieu;
    }


	

}
