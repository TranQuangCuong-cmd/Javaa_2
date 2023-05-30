<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<% Calendar c = Calendar.getInstance();

	int date = c.get(Calendar.DATE);
	int month = c.get(Calendar.MONTH)+1;
	int year = c.get(Calendar.YEAR);
	%>
	
   <div> Hôm nay, ngày <%=date%> tháng <%=month %> năm <%=year %><hr></div> 
   <form action="htkq.jsp">
     Chọn ngày:
     <select name="sngay">
     	<% for(int i=1;i<=31;i++){ %>
         <option 
         <%=(i==date)? "selected ":" " %>> <%=i%> </option>
         <%} %>
     </select>
      Chọn tháng:
     <select name="sthang">
     	<% for (int i=0;i<=11;i++){ %>
         <option <%=(i==month)? "selected":" " %>> <%=i%> </option>
         <%}%>
     </select>
     Chọn năm:
     <select name="snam">
      <% for(int i= 2012;i<=2023;i++){ %>
         <option <%=(i==year)?"selected":"" %> > <%=i%> </option>
         <% } %>
     </select>
     <input type="submit" name="but1" value="Xem kq">
   </form>
   
</body>
</html>

