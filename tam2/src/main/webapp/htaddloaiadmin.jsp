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
<style>
 .container{
 padding-top: 40px;
 text-align: center;
 }
 .submit{
 	padding-top: 30px;
 	font-size: 30px
 }
</style>
<div>
<form method="post" action="loaiadminControler" >
<div class="container">
	<div class="maloai">
	 <div> Mã Loại</div>
	 <input type="text" name="ml" value="">
	</div>
 	<div class="tenloai">
 		<div>Tên Loại</div>
 		<input type="text" name="tl" value=""> <br>
 	</div>
 	<div class="submit"><input type="submit"> </div>
  
 </div>
  </form> 
  </div>
</body>
</html>