package DTO;
//Tạo đối tượng để thực thi việc đọc và ghi dữ liệu vào database
public class chucVu {
	//Khai báo các đối tượng được ánh xạ từ các cột trong bảng sản phẩm của CSDL
	private int ma_chuc_vu;
	private String chuc_vu;
	
	//Tạo phương thức khởi tạo không đối số
	public chucVu() {
	
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
	
	
	
}
