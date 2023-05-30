<%@page import="bo.giohangbo"%>
<%@page import="java.util.Enumeration"%>
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
	Enumeration<String> d = request.getParameterNames();
	while(d.hasMoreElements()){
		String tendk = d.nextElement();
		String gt=request.getParameter(tendk);
		out.print(tendk+":"+gt+"<br>");
		
	}
	out.print("<br>");
	String[] c = request.getParameterValues("check");
	for(String st:c){
		/* out.print(st+"<br>"); */
		giohangbo gh = (giohangbo)session.getAttribute("gio");		
		gh.xoa1pt(st);
		session.setAttribute("gio", gh);
		
	}
	response.sendRedirect("htgio.jsp");
%>
</body>
</html>