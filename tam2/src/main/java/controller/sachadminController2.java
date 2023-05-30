package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.adminsachdao;

/**
 * Servlet implementation class sachadminController2
 */
@WebServlet("/sachadminController2")
public class sachadminController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet(
     */
    public sachadminController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dss =request.getParameter("dss");
		RequestDispatcher rd=null;
		if(dss== null) {
		rd=request.getRequestDispatcher("addsach.jsp");
		
		}
		else {
			adminsachdao ad = new adminsachdao();
			rd=request.getRequestDispatcher("adhtsach.jsp");
			request.setAttribute("dssach", ad.getsach());
		}
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
