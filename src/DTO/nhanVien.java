package DTO;
////Import thư viện 

import java.io.Serializable;

import com.mysql.jdbc.Blob;
//Tạo đối tượng kế thừa interface Serializable để thực thi việc đọc và ghi dữ liệu vào database
public class nhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Khai báo các đối tượng được ánh xạ từ các cột trong bảng sản phẩm của CSDL
	
	private int idnhan_vien;
	private String username;
	private String password;
	private String ho_nhan_vien;
	private String ten_nhan_vien;
	private int ma_chuc_vu;
	private String chuc_vu;
	private String email;
	private int sdt;
	private Blob hinh_nhan_vien;
	private String hinh_anh; // hien anh
	
	//Tạo phương thức khởi tạo không đối số
	public nhanVien() {
		super();
	}
	
	
	
	public Blob getHinh_nhan_vien() {
		return hinh_nhan_vien;
	}



	public void setHinh_nhan_vien(Blob hinh_nhan_vien) {
		this.hinh_nhan_vien = hinh_nhan_vien;
	}



	public String getHinh_anh() {
		return hinh_anh;
	}



	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}


	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getIdnhan_vien() {
		return idnhan_vien;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setIdnhan_vien(int idnhan_vien) {
		this.idnhan_vien = idnhan_vien;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getUsername() {
		return username;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getHo_nhan_vien() {
		return ho_nhan_vien;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setHo_nhan_vien(String ho_nhan_vien) {
		this.ho_nhan_vien = ho_nhan_vien;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getTen_nhan_vien() {
		return ten_nhan_vien;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setTen_nhan_vien(String ten_nhan_vien) {
		this.ten_nhan_vien = ten_nhan_vien;
	}
	
	
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getMa_chuc_vu() {
		return ma_chuc_vu;
	}


	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setMa_chuc_vu(int ma_chuc_vu) {
		this.ma_chuc_vu = ma_chuc_vu;
	}


	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getChuc_vu() {
		return chuc_vu;
	}


	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setChuc_vu(String chuc_vu) {
		this.chuc_vu = chuc_vu;
	}


	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getSdt() {
		return sdt;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	
}
