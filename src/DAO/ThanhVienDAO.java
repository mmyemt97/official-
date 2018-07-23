package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import DTO.ThanhVien;
import Database.Database;

public class ThanhVienDAO {
	
	public static List<ThanhVien> DocTatCa(){
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
	}

}
