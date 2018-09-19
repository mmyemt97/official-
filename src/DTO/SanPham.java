package DTO;
////Import thư viện 
import java.io.Serializable;
import java.sql.Blob;

//Tạo đối tượng Sản Phẩm kế thừa interface Serializable để thực thi việc đọc và ghi dữ liệu vào database
public class SanPham implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	//Khai báo các đối tượng được ánh xạ từ các cột trong bảng sản phẩm của CSDL
	private int ma_san_pham;
	private String tenSanPham;
	private String hangSanXuat;
	private int giaSanPham;
	private String tinhTrang;
	private Blob hinh_dai_dien; // upload, va lay du lieu 
	private String camera_truoc;
	private String camera_sau;
	private String dung_luong_pin;
	private String tinh_nang;
	private String bao_mat;
	private String mau_sac;
	private String hinh_anh; // hien anh
	
	
	
	
	
	public String getHinh_anh() {
		return hinh_anh;
	}


	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}


	//Tạo phương thức khởi tạo không đối số
	public SanPham() {
		super();
	}
	

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getMa_san_pham() {
		return ma_san_pham;
	}





	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setMa_san_pham(int ma_san_pham) {
		this.ma_san_pham = ma_san_pham;
	}




	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getMau_sac() {
		return mau_sac;
	}




	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setMau_sac(String mau_sac) {
		this.mau_sac = mau_sac;
	}




	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getCamera_truoc() {
		return camera_truoc;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setCamera_truoc(String camera_truoc) {
		this.camera_truoc = camera_truoc;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getCamera_sau() {
		return camera_sau;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setCamera_sau(String camera_sau) {
		this.camera_sau = camera_sau;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getDung_luong_pin() {
		return dung_luong_pin;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setDung_luong_pin(String dung_luong_pin) {
		this.dung_luong_pin = dung_luong_pin;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getTinh_nang() {
		return tinh_nang;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setTinh_nang(String tinh_nang) {
		this.tinh_nang = tinh_nang;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getBao_mat() {
		return bao_mat;
	}

	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setBao_mat(String bao_mat) {
		this.bao_mat = bao_mat;
	}

	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getHangSanXuat() {
		return hangSanXuat;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getTenSanPham() {
		return tenSanPham;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getGiaSanPham() {
		return giaSanPham;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setGiaSanPham(int giaSanPham) {
		this.giaSanPham = giaSanPham;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public String getTinhTrang() {
		return tinhTrang;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public Blob getHinh_dai_dien() {
		return hinh_dai_dien;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setHinh_dai_dien(Blob hinh_dai_dien) {
		this.hinh_dai_dien = hinh_dai_dien;
	}

}
