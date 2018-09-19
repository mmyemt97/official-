package DTO;
////Import thư viện
import java.io.Serializable;
//Tạo đối tượng kế thừa interface Serializable để thực thi việc đọc và ghi dữ liệu vào database
public class loaiThe implements Serializable {

	private static final long serialVersionUID = 1L;
	//Khai báo các đối tượng được ánh xạ từ các cột trong bảng sản phẩm của CSDL
	private int id_loai_the;
	private String loai_the;
	//Tạo phương thức khởi tạo không đối số
	public loaiThe() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
}
