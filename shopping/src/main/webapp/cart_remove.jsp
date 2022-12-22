<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>爱尚网扇品</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>

		<div id="page">
			<div id="header">
				<jsp:include page="header.jsp" />      
       		</div>
			
			<div id="left_column">
				<jsp:include page="left_column.jsp" />  
			</div>
			<div id="center_column">
			
				<div id="cart_tb">
						<div id="empty">
						<h3>您的购物车还是空的，</h3>
						<h3>赶紧行动吧！</h3>
						
						
					</div>
					</div>
				<div id="cart_tt">	
					合计总金额：<span id="totalPrice" style="font-size:18px;color:#f60;">0.0</span>元</td>
				</div>
				<div id="cart_lk">
				
					<a href="index.jsp">继续购物</a> | <a href="account.jsp">去收银台结账</a> | <a href="cart_remove.jsp">清空购物车</a>
					
				</div>
			
			</div>
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>
	
		<%
	/* session.invalidate(); */
	%>
	
</body>
</html>