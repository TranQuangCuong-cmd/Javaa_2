<%@page import="bean.chitiethoadonbean"%>
<%@page import="bean.hoadonbean"%>
<%@page import="bean.khachhangbean"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
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
<style>
	.tongtien{
		float:right;
	}
	.xoatatca{
		float: right;
	}
	.btn-tt{
		float:right;
		background-color: #00d4ff;
		color: #fff;
		font-size: 30px;
	}
	.btn-tt:hover{
	 background-color: #1dfd65;
	}
</style>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="htsachController">Trang chủ</a></li>
      <li><a href="htgio">Giỏ hàng</a></li>
        <li><a href="thanhtoan">Thanh toán</a></li>
          <li><a href="lichsu">Lịch sử mua hàng: </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="dangky"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <%if(session.getAttribute("dn")==null){ %>
      <li><a href="dangnhap">
      <span class="glyphicon glyphicon-log-in"></span> 
      		Login
      </a></li>
      <%}else{ %>
      <li><a href="thoat">
      <span class="glyphicon glyphicon-log-in"></span> 
      			Hi: <%=((khachhangbean)session.getAttribute("dn")).getHoten() %>
      </a></li>
      <%} %>
    </ul>
  </div>
</nav>
<%/* loaibo lbo=new loaibo();
  sachbo sbo=new sachbo(); */
  
  /* giohangbo gh=(giohangbo)session.getAttribute("gio"); */
%>
<table width ="1000" align="center">
   <tr>
      <td width ="600" valign="top">
      <table class="table table-hover">
           <tr>
             <td>Mã Chi Tiết Hóa Đơn</td>
             <td>Mã Sách</td>
             <td>Số Lượng Mua</td>
             <td>Mã Hóa Đơn</td>
             <td>Đã Mua</td>
           </tr>			    
	    	
	    <%   
	    	ArrayList<chitiethoadonbean> gh1 = (ArrayList<chitiethoadonbean>)request.getAttribute("list");
		   if(gh1!=null){ 
		   
		   for(chitiethoadonbean h: gh1){%>
		   	<tr>	
		   		<td><%=h.getMaChiTietHD() %></td>   		  		   	   	
			   	<td><%=h.getMaSach() %></td>
				<td><%=h.getSoLuongMua()%></td>
				<td><%=h.getMaHoaDon()%></td> 	
		   		<td><%=h.isDaMua() %>		   	
		   	</tr> 	   			  	
		<%}		  
 	   }	  
	%>
			 
</table>
    
  		
</body>
</html>