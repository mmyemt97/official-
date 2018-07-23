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
	public static List<chucVu> danhSachChucVu(){
		List<chucVu> dsChucVu = null;
		String sql = "SELECT*FROM chuc_vu";
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			dsChucVu = new ArrayList<>();
			while(rs.next()) {
				chucVu cv = new chucVu();
				cv.setMa_chuc_vu(rs.getInt("ma_chuc_vu"));
				cv.setChuc_vu(rs.getString("chuc_vu"));
				
				dsChucVu.add(cv);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsChucVu;
		
	}
}
