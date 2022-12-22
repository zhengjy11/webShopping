<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<jsp:useBean id="product" class="com.model.Product" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
				<div id=item_img>
					<img width="300px" height="225px" src="<jsp:getProperty property="img" name="product"/>" />
				</div>
				<div id=item_other>
					<form action="AddCartServlet" method="post">
						品&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;<span  style="font-size:15px;font-weight:bold;"><jsp:getProperty property="name" name="product"/></span><br>
						原&nbsp;&nbsp;&nbsp;&nbsp;价：&nbsp;<span  style="text-decoration: line-through;"><jsp:getProperty property="price" name="product"/>元</span><br>
						促&nbsp;&nbsp;&nbsp;&nbsp;销：&nbsp;<span  style="font-size:28px;font-weight:bold;color:#B22222;"><jsp:getProperty property="oneprice" name="product"/></span>元<br>
						售&nbsp;&nbsp;&nbsp;&nbsp;出：&nbsp;<span  style="font-weight:bold;color:#CC6600;"><jsp:getProperty property="sale" name="product"/></span>件<br>
						数&nbsp;&nbsp;&nbsp;&nbsp;量：&nbsp;<input type="text" name="quantity" size="6" style="color:#66668C;">件<p>
						<img src="images/buy_button.png" />&nbsp;&nbsp;
					
						<input type="hidden" name="id" value="<jsp:getProperty property="id" name="product"/>">
						<!-- <input type="hidden" name="name" value="油漆边双色龙骨扇_粉色">
						<input type="hidden" name="price" value="18"> -->
						<input type="image" src="images/shopping_button.png" name="submit" value="加入购物车"></p>
					</form>
				</div>
				<div id=item_details><img src="images/details.gif" /></div>
				<div id="item_parameter">
					<div style="float: left;width:230px;color:#404040;">&nbsp;&nbsp;&nbsp;货号：<jsp:getProperty property="id" name="product"/></div><div style="float: left;width:230px;color:#404040;">类别：<jsp:getProperty property="sort" name="product"/></div><div style="float: left;width:230px;color:#404040;">扇面材质:<jsp:getProperty property="face" name="product"/></div><br>
					<div style="float: left;width:230px;color:#404040;">&nbsp;&nbsp;&nbsp;扇骨材质：<jsp:getProperty property="body" name="product"/></div><div style="float: left;width:230px;color:#404040;">扇骨数量：<jsp:getProperty property="quantity" name="product"/>根</div><div style="float: left;width:230px;color:#404040;">扇骨长度：<jsp:getProperty property="length" name="product"/>CM</div>
				</div>
				<div id="item_show_img">
					<img style="width:600px;" src="<jsp:getProperty property="source" name="product"/>" />
				</div>
			</div>
			
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>
	
</body>
</html>