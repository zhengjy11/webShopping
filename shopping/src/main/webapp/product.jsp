<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Vector" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>爱尚网扇品</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	<%!int count; %>
	<div id="page">
		<div id="header">
			<jsp:include page="header.jsp" />      
       	</div>
			
		<div id="left_column">
			<jsp:include page="left_column.jsp" />  
		</div>
			
		<div id="center_column">		
			<div class="divBorder">
				<img src="images/all_fans.gif" /><br>
				<%
				Vector<Vector<String>> products1 = (Vector<Vector<String>>)request.getAttribute("products1");
				Vector<Vector<String>> products = (Vector<Vector<String>>)request.getAttribute("products");
				if(products==null){
					response.sendRedirect("ShowProductServlet");
					
					return;
				}
				count = products1.size();
					for(int i=0;i<products.size();i++){
						Vector<String> product = products.get(i);
					%>
					
					<div id='sort_product'>
					<ul>
						<li><p class='gpic'><a href='ShowProDetailServlet?productid=<%=product.get(0) %>'><img width='205' height='154' src="<%=product.get(2)%> "></a></p></li> 
						<li><p class='gbt'><a href='ShowProDetailServlet?productid=<%=product.get(0) %>'>品名：<%=product.get(1) %> </a></p></li>
						<li><p class='gprice'>促销价：<span style="color:#FF6600;font-weight:bold;"></span>￥<%=product.get(3) %>元</p></li>
						<li><p class='gsale'>已售出：<span style='font-weight:bold;'><%=product.get(4) %></span>&nbsp;笔</p></li>
					</ul>
					</div>
					<%
					}
				%>
			
				
				
			</div>	
				<form action="ShowProductServlet" method="post">
				<div id='page_next'>
				<%
				for(int i=0;i<count/9+1;i++){
				%>
				<input class="submit-page" type="submit" name="name" value="<%=i+1 %>">&nbsp;&nbsp;
				<% 
				}
				%>
				</div>
				</form>
				<!-- <div id='page_next'><a class="pageLink" href="">上一页</a>&nbsp;<a class="pageLink" href="">下一页</a>&nbsp;</div>  -->  	
			</div>
					
		<div id="footer">
			<jsp:include page="bottom.jsp" />  
		
	</div>
</body>
</html>