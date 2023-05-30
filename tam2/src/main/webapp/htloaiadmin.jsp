<%@page import="bean.xacnhanbean"%>
<%@page import="bean.dangnhapadminbean"%>
<%@page import="bean.khachhangbean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="bean.sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="adminController">Trang chủ</a></li>
      <li><a href="loaiadminControler">Quản lý loại</a></li>
        <li><a href="sachadminController">Quản lý sách</a></li>
        
        <li><a href="xacnhanController">Xác nhận</a></li>
        <li><a href="danhsachchuyentienController">Khách hàng chuyển tiền</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="thoat.jsp"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
      <%if(session.getAttribute("admin")==null){ %>
      <li><a href="dangnhapadminController">
      <span class="glyphicon glyphicon-log-in"></span> 
      		Login
      </a></li>
      <%}else{ %>
      <li><a href="#">
      <span class="glyphicon glyphicon-log-in"></span> 
      		Hi: <%dangnhapadminbean kh =
      		(dangnhapadminbean)session.getAttribute("admin");
      		    out.print(kh.getTenDangNhap());
      		%>
      </a></li>
      <%} %>
    </ul>
  </div>
</nav>
<div style="padding-left: 300px;padding-right: 300px">
	<table class="table table-hover">
      <tr>
      		<td> <h3>Mã Loại</h3></td>
      		<td> <h3>Tên Loại</h3>	</td>
      		
      </tr>
	<button style ="font-size: 30px; text-align: center;align-items: center;"><a href="loaiadminControler?add=1">Thêm loại sách</a></button>


	   <c:forEach var="t"  items="${dsl}">
		   	<tr>
		   	
		   	<td> ${t.getTenloai()}	</td>
		   	<td> ${t.getMaloai()}	</td>
		   	
		   	</tr>
			 </c:forEach>
			  
    </table>
</div>
  
</body>
</html>
