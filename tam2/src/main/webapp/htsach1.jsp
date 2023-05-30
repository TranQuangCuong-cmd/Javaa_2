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
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                 <div >
                	<c:forEach var="l" items="${dsloai}">
                    	<a href="htsach?ml=${l.getMaloai()}" class="list-group-item">
			               ${l.getTenloai()}
			     
			            </a>
                      </c:forEach>
                </div>
            </div>


            <div class="col-md-9">
                <div>
                    <div class="row">
                    <c:forEach var="s" items="${dssach}">
                    <div class=" col-lg-4 col-md-4" style="height: 420px">
                            <div class="thumbnail">
                                    <img alt="${s.getTensach()}" src="${s.getAnh()}" style="width: 300px; height: 280px;"/>
                                    <div>
                                        <br />
                                        <div >
                                        	<p style="font-weight: bold;font-size: 18px; text-align: center;">
	                                           ${s.getTensach()}
	                                        </p>
                                        </div>
                                        
                                    </div>
                                      <div style="width:100px; margin-left: 80px">
                                      	<a href="giohang?ms=${s.getMasach()}&ts=${s.getTensach()}&gia=${s.getGia()}&anh=${	s.getAnh()}">
							              <img src="mua.jpg">
							            </a>
                                      </div>
                                
                            </div>
                        </div>
                       </c:forEach>   
                    </div>

	                <div class="page_container">
	                   <ul class="pagination">
	                      <li><a href="htsach?page=1">1</a></li>
	                      <li><a href="htsach?page=2">2</a></li>
	                      <li><a href="htsach?page=3">3</a></li>
	                      <li><a href="htsach?page=4">4</a></li>
	                      <li><a href="htsach?page=5">5</a></li>
	                        		
	                   </ul>
	                </div>
                    
                    
                </div>
            </div>
        </div>
    </div>

</body>
</html>
