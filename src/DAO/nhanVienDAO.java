package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import DTO.nhanVien;
import Database.*;

public class nhanVienDAO {
	public static List<nhanVien> DocTatCa(){
		List<nhanVien> dsNhanVien = null;
		
		
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM nhan_vien INNER JOIN chuc_vu ON nhan_vien.ma_chuc_vu = chuc_vu.ma_chuc_vu");
			dsNhanVien = new ArrayList<>();
			while(rs.next()) {
				
				nhanVien nv = new nhanVien();
				nv.setIdnhan_vien(rs.getInt("idnhan_vien"));
				nv.setUsername(rs.getString("username"));
				nv.setPassword(rs.getString("password"));
				nv.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nv.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				nv.setChuc_vu(rs.getString("chuc_vu"));
				nv.setEmail(rs.getString("email"));
				nv.setSdt(rs.getInt("sdt"));
				
				dsNhanVien.add(nv);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		return dsNhanVien;
	}
}
