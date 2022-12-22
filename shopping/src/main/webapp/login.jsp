<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>

<body>
	<div id="page">
		<div id="header">
			<jsp:include page="header.jsp" />      
       	</div>
		
	<div id="div_reg">
       		<h3>会员登录</h3><br>
       		<hr size=1>
	<div id="div_login">
    <div id="div_login_leftimg">
		<img src="images/boy.gif" />
	</div>
	<div id="div_login_form">
		<form action="LoginServelt" method="post">
			<font class="zt2">
			 <%
         String strMess=(String)request.getAttribute("mess");
		if(strMess==null){
			strMess="";
		}
		%>
		<%=strMess %>
			</font><br>
			<label for="useName">用户名：</label>
			<input type="text" name="useName" id="txtName" class="input"><br><br>
			<label for="passWord">密&nbsp;&nbsp;&nbsp;码：</label>
			<input type="password" name="pwd" id="passWord" class="input"><br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          	<input name="imageField" type="image" src="images/login_button.gif" />
      		<a href="reg.jsp"><img src="images/reg_button.gif" border= "0 " /></a>
         </form>
        
	</div>
	<div id="div_login_rightimg">
		<img src="images/girl.gif" />
	</div>
    </div>
	</div>  	
    <div id="footer">
		<jsp:include page="bottom.jsp" />  
	</div>
	</div>
</body>

</html>