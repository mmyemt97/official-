package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DAO.ThemNVDAO;
import DTO.nhanVien;
import Database.*;

/**
 * Servlet implementation class ThemNVController
 */
@WebServlet("/ThemNVController")
public class ThemNVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemNVController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("txtMaNhanVien"));
		System.out.println("id: " + id);
		String username = request.getParameter("txtusername");
		String password = request.getParameter("txtpassword");
		String ho_nhan_vien = request.getParameter("txtHoNhanVien");
		String ten_nhan_vien = request.getParameter("txtTenNhanVien");
		String email = request.getParameter("txtEmail");
		int sdt = Integer.parseInt(request.getParameter("txtsdt"));
		
		nhanVien nv = new nhanVien();
		nv.setId(id);
		nv.setPassword(password);
		nv.setEmail(email);
		nv.setSdt(sdt);
		nv.setHo_nhan_vien(ho_nhan_vien);
		nv.setTen_nhan_vien(ten_nhan_vien);
		nv.setUsername(username);
		
		int themNhanVien = 0;
		themNhanVien = ThemNVDAO.Them(nv);
		
		if(themNhanVien != 0) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("error.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
