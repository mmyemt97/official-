package DTO;
////Import thư viện
import java.io.Serializable;
//Tạo đối tượng kế thừa interface Serializable để thực thi việc đọc và ghi dữ liệu vào database
public class ThanhVien implements Serializable {

	private static final long serialVersionUID = 1L;
	//Khai báo các đối tượng được ánh xạ từ các cột trong bảng sản phẩm của CSDL
	private int iduser;
	private String username;
	private String password;
	private String ho_user;
	private String ten_user;
	private int sdt;
	private String email;
	private String dia_chi;
	private String quan;
	private String phuong;
	private String thanh_pho;
	private String nuoc;
	private String zip_code;
	private int diem;
	private String loai_the;
	//Tạo phương thức khởi tạo không đối số
	public ThanhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getDiem() {
		return diem;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setDiem(int diem) {
		this.diem = diem;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getLoai_the() {
		return loai_the;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setLoai_the(String loai_the) {
		this.loai_the = loai_the;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getIduser() {
		return iduser;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getUsername() {
		return username;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setUsername(String username) {
		this.username = username;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getPassword() {
		return password;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setEmail(String email) {
		this.email = email;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getDia_chi() {
		return dia_chi;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
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
	public String getPhuong() {
		return phuong;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getThanh_pho() {
		return thanh_pho;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setThanh_pho(String thanh_pho) {
		this.thanh_pho = thanh_pho;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getNuoc() {
		return nuoc;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setNuoc(String nuoc) {
		this.nuoc = nuoc;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getZip_code() {
		return zip_code;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
