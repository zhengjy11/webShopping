<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��������Ʒ</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	
	<%!float sumPrice; %>
	
		<div id="page">
			<div id="header">
				<jsp:include page="header.jsp" />      
       		</div>
			
			<div id="left_column">
				<jsp:include page="left_column.jsp" />  
			</div>
			<div id="center_column">
			<%
			Vector<Vector<String>> products = (Vector<Vector<String>>)session.getAttribute("productCart");
			sumPrice=0;
			for(int i=0;i<products.size();i++){
				Vector<String> product = products.get(i);
				 sumPrice = sumPrice + Float.parseFloat( product.get(4));
			}
			%>
					<div id="empty">
						<h3>��ܰ��ʾ����������</h3>
						<h3>�ϼ��ܽ�<span id="totalPrice" style="font-size:18px;color:#f60;"><%=sumPrice %></span>Ԫ</h3>
					</div>
				<div id="cart_tt">	
					<form action="PayServlet" method="post">
					<input type="submit" value="����" style="font-size:18px;color:#ff0000;" >
					</form>
				</div>
				<div id="cart_lk">
					<a href="index.jsp">��������</a> | <a href="cart_view.jsp">���ع��ﳵ</a> 
				</div>
			
			</div>
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>
	
</body>
</html>