package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class themhoadon
 */
@WebServlet("/themhoadon")
public class themhoadon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themhoadon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		khachhangbean kh = (khachhangbean) session.getAttribute("dn");
		if(kh == null) {
			response.sendRedirect("dangnhap");
			return;
		}
		giohangbo gio = (giohangbo) session.getAttribute("gio");
		if(gio == null) {
			response.sendRedirect("htsach");
			return;
		}
		hoadonbo hdbo = new hoadonbo();
		int rs = hdbo.themhoadon(0, null, false);
		chitiethoadonbo cthdbo = new chitiethoadonbo();
		cthdbo.insert(rs, gio);
		session.removeAttribute("gio");
		response.sendRedirect("htsach");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
