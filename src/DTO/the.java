package DTO;
////Import thư viện
import java.io.Serializable;
//Tạo đối tượng kế thừa interface Serializable để thực thi việc đọc và ghi dữ liệu vào database
public class the implements Serializable {
	private static final long serialVersionUID =1L;
	//Khai báo các đối tượng được ánh xạ từ các cột trong bảng sản phẩm của CSDL
	private int id_the_tich_diem;
	private int diem;
	private int id_loai_the;
	private String loai_the;
	private int so_luong;
	
	//Tạo phương thức khởi tạo không đối số
	public the() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Tạo getter để lấy giá trị mã sản phẩm từ CSDL
	public int getId_the_tich_diem() {
		return id_the_tich_diem;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setId_the_tich_diem(int id_the_tich_diem) {
		this.id_the_tich_diem = id_the_tich_diem;
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
	public int getId_loai_the() {
		return id_loai_the;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setId_loai_the(int id_loai_the) {
		this.id_loai_the = id_loai_the;
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
	public int getSo_luong() {
		return so_luong;
	}
	//Tạo setter để gán giá trị mã sản phẩm vào CSDL
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	
	
	
}
