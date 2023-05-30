<%@page import="bean.khachhangbean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="htsach">Trang chủ</a></li>
      <li><a href="htgio">Giỏ hàng</a></li>
        <li><a href="danggiaohang">Thanh toán</a></li>
          <li><a href="lichsugiaohang">Lịch sử mua hàng: <%=session.getAttribute("ss") %></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="thoat.jsp"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
      <%if(session.getAttribute("dn")==null){ %>
      <li><a href="ktdn">
      <span class="glyphicon glyphicon-log-in"></span> 
      		Login
      </a></li>
      <%}else{ %>
      <li><a href="#">
      <span class="glyphicon glyphicon-log-in"></span> 
      	Hi: <%=((khachhangbean)session.getAttribute("dn")).getHoten() %>
      </a></li>
      <%} %>	
    </ul>
  </div>
</nav>
<table class="table table-hover">
      <tr>
      		<td>Ngày mua</td>
      		<td>Mã sách	</td>
      		<td>Tên sách</td>
			<td>Số lượng mua</td>
			<td>Giá</td>
			<td>Thành tiền	</td>
      </tr>
	   <c:forEach var="t"  items="${ls}">
		   	<tr>
		   	
		   	<td> ${t.getNgayMua()}	</td>
		   	<td> ${t.getMaSach()}	</td>
		   	<td> ${t.getTensach()}	</td>
		   	<td> ${t.getSoLuongMua()}	</td>
		   	<td> ${t.getGia()}	</td>
		   	<td> ${t.getThanhtien()}	</td>
		   	</tr>
			 </c:forEach>
			  
    </table>
	
</body>
</html>