package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import DTO.the;
import Database.Database;

public class theDAO {
	//luu tat ca ket qua vao` List the
	public static List<the> DocTatCa(){
		//ban đầu chưa có thẻ, list là null
		List<the> dsThe = null;
		
		try {
			//kết nối với CSDL thông qua lớp Database ( khởi tạo)
			Connection db = Database.connect();
			//Sau khi kết nối thành công, thực thi lệnh SQL ( Statement)
			Statement stm = db.createStatement();
			//ResultSet nhận kết quả excute từ statement
			ResultSet rs = stm.executeQuery("SELECT the_tich_diem.id_the_tich_diem,diem ,the_tich_diem.id_loai_the,loai_the.loai_the, count(*) as `so_luong_the`\r\n" + 
					"FROM the_tich_diem\r\n" + 
					"JOIN loai_the ON loai_the.id_loai_the = the_tich_diem.id_loai_the\r\n" + 
					"GROUP BY id_loai_the\r\n");
			//new ArrayList của List Sản phẩm để lưu dữ liệu
			dsThe = new ArrayList<>();
			//nhận dữ liệu đọc từ đầu đến cuối, thông qua lệnh while, rs ( ResultSet).next(), là đọc lần lượt vị trí 1 2 3..n) 
			while(rs.next()){
				//khởi tạo đối tượng the để lưu từ rs 
				the the = new the();
				//lưu vào đối tượng the, ứng với cột trong csdl
				the.setId_the_tich_diem(rs.getInt("id_the_tich_diem"));				
				the.setDiem(rs.getInt("diem"));
				the.setLoai_the(rs.getString("loai_the"));
				the.setSo_luong(rs.getInt("so_luong_the"));	
				//Thực hiện việc thêm thẻ
				dsThe.add(the);		
				
			}
			
			//Bắt trường hợp không kết nối được CSDL
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Trả lại dsThe
		return dsThe;
	}
	
	
}
