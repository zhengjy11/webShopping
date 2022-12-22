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
				<%-- <%=request.getAttribute("a") %> --%>
				<%
				Vector<Vector<String>> search = (Vector<Vector<String>>)request.getAttribute("search");
				if(search==null){
					%>
					<h3>对不起，未找到您查询的商品！</h3>
					<% 
				}
				count = search.size();
					for(int i=0;i<search.size();i++){
						Vector<String> searchProduct = search.get(i);
					%>
					
					<div id='sort_product'>
					<ul>
						<li><p class='gpic'><a href='ShowProDetailServlet?productid=<%=searchProduct.get(0) %>'><img width='205' height='154' src="<%=searchProduct.get(2)%> "></a></p></li> 
						<li><p class='gbt'><a href='ShowProDetailServlet?productid=<%=searchProduct.get(0) %>'>品名：<%=searchProduct.get(1) %> </a></p></li>
						<li><p class='gprice'>促销价：<span style="color:#FF6600;font-weight:bold;"></span>￥<%=searchProduct.get(3) %>元</p></li>
						<li><p class='gsale'>已售出：<span style='font-weight:bold;'><%=searchProduct.get(4) %></span>&nbsp;笔</p></li>
					</ul>
					</div>
					<%
					}
					%>
			
				
				
			</div>	

			</div>
					
		<div id="footer">
			<jsp:include page="bottom.jsp" />  
		
	</div>
</body>
</html>