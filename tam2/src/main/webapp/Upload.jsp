<%@page import="bo.giohangbo"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
		String masach=request.getParameter("btnUpdate");	
		String sl=request.getParameter("soluong"+masach);				// sl đang là string
		String delete = request.getParameter("btnDalete");
		String clear= request.getParameter("deleteall");
		//out.print(n+":"+masach);
   		//tao biến session
		giohangbo gh;
		// bước 1:
		gh=(giohangbo) session.getAttribute("gio");
		//b2: Thao tac trên bien: gh
		if (sl!=null && masach!=null){		
			long nn=Long.parseLong(sl); // số lượng là kiểu long, Long là kiểu .parselong là đổi sl String về long
			// cập nhật số lương
			gh.UpdateSl(masach,(long) nn);	
		}
		if (delete!=null){					
			gh.xoa1pt(delete);
		}
		// bước 3
		//đưa vào ass
		session.setAttribute("gio", gh);
		if (clear!=null){					// 
			session.removeAttribute("gio");	// 
		}
		
		
		//Hien thi gio
		response.sendRedirect("htgio.jsp");
%>
 	
</body>

</body>
</html>