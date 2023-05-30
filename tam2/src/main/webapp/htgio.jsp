<%@page import="bean.khachhangbean"%>
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
      <li><a href="dangnhap.jsp">
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

<table width ="1000" align="center">
   <tr>
     <td width ="200" valign="top">
       <table class="table table-hover">
         <%
         ArrayList<loaibean> dsloai = (ArrayList<loaibean>)request.getAttribute("dsloai");
        
         for(loaibean l: dsloai){ %>
         <tr><td>
           <a href="htsach?ml=<%=l.getMaloai()%>">
               <%=l.getTenloai() %>
            </a>
           </td>
           </tr>
           <%} %>
        
          
      
       </table>
     </td>
      <td width ="700" valign="top">
      
      <form action="Update">
      <table class="table table-hover">
      <tr>
      		<td>Check	</td>
      		<td>Mã sách	</td>
			<td>Tên sách</td>
			<td>Giá sách 	</td>
			<td>Số lượng	</td>
			<td>Thành tiền	</td>
      </tr>
	    <%
	   giohangbo gh;
	   gh = (giohangbo)session.getAttribute("gio");
	    // ở đây đã hoàn thành bước 1 là lấy dữ liệu ra nên tới bước 2
	   if(gh!=null){
		   for(giohangbean h: gh.ds){%>
		   	<tr>
		   	<td>
		   		<input type="checkbox" name="check" value="<%=h.getMasach() %>" form="clickme">
		   	</td>
		   	<td> <%=h.getMasach() %> 	</td>
		   	<td> <%=h.getTensach() %> 	</td>
		   	<td> <%=h.getGia() %> 	</td>
		   	<td>	<input type="number" min="0" name="soluong<%=h.getMasach()%>" value=<%=h.getSoluong()%> style = "width: 50px";>  
			   		<button name="btnUpdate" value=<%=h.getMasach() %> type="submit" > 
			   			Update
			   		</button>
			</td>
		   	<td> 	<%=h.getThanhtien() %> 	</td>
		   	<td>	<button name="btnDalete" value=<%=h.getMasach() %>  type="submit" >	
			   			Delete
			   		</button> 
		   	</td>
		   	</tr>
			 
			  
		<%   }
	   }
%>
    </table>
     
    <button name="deleteall" value=""  type="submit" >	
			   			Xóa Tất Cả
	</button>
	</form>
	<form action="xoacheck" id="clickme">
	 <button style="margin-top: 20px" name="deleteclick" value=""  type="submit" >	
			   			Xóa mục chọn
	</button> 
   </form>
  	<h1>Tổng tiền:  <%	if(gh!=null){
  		 					out.print(gh.Tongtien());
  						}
					  	else{
					  		out.print("0");	
					  	}
  					%>
  	</h1>	
  		<form action="dathang">
  	 <button style="margin-top: 20px ; font-size: 30px; margin-left: 120px; border-radius: 10px" name="but1" value=""  type="submit" >	
			   			Xác Nhận Đặt Hàng
	</button> 
	</form>
	<td width ="200" valign="top">
	    <form action="htsach" method="post">
	 		<input  class="form-control"  name="txttk" type="text" value="" placeholder="Nhap tt"> <br>
	  		<input class="btn-primary"  name="butt" type="submit" value="Search">
		</form>
    </td>
   </tr>
</table>
</body>
</html>

