package DTO;
////Import thư viện
import java.io.Serializable;
//Tạo đối tượng kế thừa interface Serializable để thực thi việc đọc và ghi dữ liệu vào database
public class DonHang implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//Khai báo các đối tượng được ánh xạ từ các cột trong bảng sản phẩm của CSDL
	private int ma_don_hang;
	private int ma_khach_hang;
	private String email;
	private String ho_user;
	private String ten_user;
	private int sdt;
	private String diaChi;
	private String phuong;
	private String quan;
	private String chi_tiet;
	
	//Tạo phương thức khởi tạo không đối số
	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getMa_don_hang() {
		return ma_don_hang;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setMa_don_hang(int ma_don_hang) {
		this.ma_don_hang = ma_don_hang;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getMa_khach_hang() {
		return ma_khach_hang;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setMa_khach_hang(int ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getEmail() {
		return email;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setEmail(String email) {
		this.email = email;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getHo_user() {
		return ho_user;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setHo_user(String ho_user) {
		this.ho_user = ho_user;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getTen_user() {
		return ten_user;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setTen_user(String ten_user) {
		this.ten_user = ten_user;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getSdt() {
		return sdt;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getDiaChi() {
		return diaChi;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getPhuong() {
		return phuong;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getQuan() {
		return quan;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setQuan(String quan) {
		this.quan = quan;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getChi_tiet() {
		return chi_tiet;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setChi_tiet(String chi_tiet) {
		this.chi_tiet = chi_tiet;
	}
	
	
	
	
}
