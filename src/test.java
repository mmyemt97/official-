import java.util.List;

import DAO.DonHangDAO;
import DAO.SanPhamDAO;
import DAO.chucVuDAO;
import DTO.DonHang;
import DTO.SanPham;
import DTO.chucVu;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test CSDL");
		List<chucVu> dsChucVu = chucVuDAO.danhSachChucVu();
		
		for(chucVu cv : dsChucVu) {
			System.out.println("Mã cv : " + cv.getMa_chuc_vu() + " - " + "Tên chuc vu: " + cv.getChuc_vu());
		}
	}

}
