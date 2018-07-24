package DTO;

import java.io.Serializable;

public class nhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idnhan_vien;
	private String username;
	private String password;
	private String ho_nhan_vien;
	private String ten_nhan_vien;
	private String chuc_vu;
	private String email;
	private int sdt;
	
	public nhanVien() {
		super();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getIdnhan_vien() {
		return idnhan_vien;
	}

	public void setIdnhan_vien(int idnhan_vien) {
		this.idnhan_vien = idnhan_vien;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHo_nhan_vien() {
		return ho_nhan_vien;
	}

	public void setHo_nhan_vien(String ho_nhan_vien) {
		this.ho_nhan_vien = ho_nhan_vien;
	}

	public String getTen_nhan_vien() {
		return ten_nhan_vien;
	}

	public void setTen_nhan_vien(String ten_nhan_vien) {
		this.ten_nhan_vien = ten_nhan_vien;
	}
	
	public String getChuc_vu() {
		return chuc_vu;
	}

	public void setChuc_vu(String chuc_vu) {
		this.chuc_vu = chuc_vu;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	
}
