package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class xoacheck
 */
@WebServlet("/xoacheck")
public class xoacheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoacheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		Enumeration<String> d = request.getParameterNames();
		while(d.hasMoreElements()){
			String tendk = d.nextElement();
			String gt=request.getParameter(tendk);	
		}
		
		String[] c = request.getParameterValues("check");
		for(String st:c){
			/* out.print(st+"<br>"); */
			giohangbo gh = (giohangbo)session.getAttribute("gio");		
			gh.xoa1pt(st);
			session.setAttribute("gio", gh);
		}
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
