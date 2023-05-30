package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.khachhangbean;
import bean.lichsubean;
import dao.hoadondao;

/**
 * Servlet implementation class danggiaohang
 */
@WebServlet("/danggiaohang")
public class danggiaohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public danggiaohang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		khachhangbean kh= (khachhangbean)session.getAttribute("dn");
		hoadondao hddao = new hoadondao();
		ArrayList<lichsubean> ls = hddao.getlichsu(0,kh.getMakh());
		request.setAttribute("ls", ls);
		for (lichsubean t : ls) {
			System.out.println(t.getMaSach());
		}
		RequestDispatcher rd=request.getRequestDispatcher("danggiaohang.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
