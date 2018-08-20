package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import DTO.nhanVien;

@WebServlet("/nhanVienDangNhap")
public class nhanVienDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public nhanVienDangNhap() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username, password;
		username = request.getParameter("user");
		password = request.getParameter("password");
		
		nhanVien nv_dangnhap = nhanVienDAO.docTheoUsernamePassword(username, password);
		if(nv_dangnhap != null) {
			HttpSession session = request.getSession();
			session.setAttribute("staff", nv_dangnhap);
			response.sendRedirect("cong-viec.jsp");
		}
		else {
			response.sendRedirect("log-in-staff.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
