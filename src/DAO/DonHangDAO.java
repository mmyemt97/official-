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
	public static List<DonHang> DocTatCa(){
		List<DonHang> dsDonHang = null;
		
		
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM gio_hang");
			dsDonHang = new ArrayList<>();
			
			while(rs.next()) 
			{
				DonHang dh = new DonHang();
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
				
				dsDonHang.add(dh);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dsDonHang;
	}
	
}
