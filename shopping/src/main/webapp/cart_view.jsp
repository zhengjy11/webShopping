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

			%>
			
			<div id="cart_tb">
				<%if(products==null){ 
				sumPrice=0;
				%>
					<div id="empty">
						<h3>���Ĺ��ﳵ���ǿյģ�</h3>
						<h3>�Ͻ��ж��ɣ�</h3>
					</div>
				<%
				}else{ 
					
					%>
						<img src="images/shopping_card.gif" />
						<table>
							<tr>
								<td width="10%"><span style="color:#696969;size:13;font-weight:bold;">���</span></td>
								<td width="30%"><span style="color:#696969;size:13;font-weight:bold;">��Ʒ����</span></td>
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">���ۣ�Ԫ��</span></td>
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">����</span></td>
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">С�ƣ�Ԫ��</span></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>		
								<%
								sumPrice=0;
								for(int i=0;i<products.size();i++){
									Vector<String> product = products.get(i);
									 sumPrice = sumPrice + Float.parseFloat( product.get(4));
									%>			
									<tr>
										<td><%=product.get(0) %></td>
										<td><%=product.get(1) %></td>
										<td><%=product.get(2) %></td>
										<td><%=product.get(3) %></td>
										<td><%=product.get(4) %></td>
							
									</tr>
									<%
									}
									%>
			
									
						</table>
							<% 
					
				}
				%> 
					</div>
				
				
				<div id="cart_tt">	
					�ϼ��ܽ�<span id="totalPrice" style="font-size:18px;color:#f60;"><%=sumPrice %></span>Ԫ</td>
				</div>
				<div id="cart_lk">
					<a href="index.jsp">��������</a> | <a href="account.jsp">ȥ����̨����</a> | <a href="EmptyCartServlet">��չ��ﳵ</a> 
				</div>
			
			</div>
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>
	
</body>
</html>