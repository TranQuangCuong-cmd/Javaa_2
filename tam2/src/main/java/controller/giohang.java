package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class giohang
 */
@WebServlet("/giohang")
public class giohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String masach =request.getParameter("ms");
			String tensach =request.getParameter("ts");
		long gia=Long.parseLong(request.getParameter("gia"));
			giohangbo gh=null;
			HttpSession session = request.getSession();
			//Neu mua lan dau thi tao cho kh 1 gio: session
			if(session.getAttribute("gio")==null){
				gh=new giohangbo();//Cap phat vung nho de luu gio
				session.setAttribute("gio", gh);//Tao session
			}
			//b1: Luu session ra bien
			gh=(giohangbo)session.getAttribute("gio");
			//b2: Thay doi bien
			gh.Them(masach, tensach, gia, (long)1);
			session.setAttribute("gio", gh);
			//Hien thi gio
			response.sendRedirect("htgio");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
