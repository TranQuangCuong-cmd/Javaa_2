package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.chitiethoadonbean;
import bo.chitiethoadonbo;

/**
 * Servlet implementation class chitiethoadon
 */
@WebServlet("/chitiethoadon")
public class chitiethoadon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitiethoadon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mahd = request.getParameter("mahd");
		int x = 0;
		if(mahd != null) x = Integer.parseInt(mahd);
		chitiethoadonbo cthdbo = new chitiethoadonbo();
		ArrayList<chitiethoadonbean> list = cthdbo.getchitiethoadon(x);
		request.setAttribute("list", list);
		request.getRequestDispatcher("chitiethoadon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
