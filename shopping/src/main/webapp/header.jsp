<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="userinfo" class="com.model.Userinfo" scope="session"/>
<script>
function openWin(url,width,height){
var phxWin=window.open(url,'','width='+width+',height='+height+',left='+(screen.width-width)/2+',top='+(screen.height-height)/2+'');
}
</script>
	
	<div id="logo">
		<a href="#"><img src="images/logo.png" border= "0 "/></a>
	</div>
	
	<div id="header_right">
		<%
			String userName = userinfo.getUsername();
      		if(userName == null){
      	%>
		欢迎光临，<a href="reg.jsp">注册</a>/<a href="login.jsp">登陆</a>
		<%
      	}else if(userName != null){
      		%>
      		<jsp:getProperty property="username" name="userinfo"/><span style='color:red'>,欢迎光临!</span>
      		<%
      	}
      	%>
		<form action="exit.jsp" method="post">
      		<input type="submit" name="exit" value="注销">
      	</form>
		<br>
		<img src="images/chat.png" />&nbsp;<a onClick="openWin('contact.jsp',300,200)" style="cursor:hand" >联系我们</a> <img src="images/order.png" />&nbsp;<a href="cart_view.jsp">购物车</a>
	</div>

	<div id="headermenu">

		<ul id="menu">
		<li>
			<a class="li" href="index.jsp"><img src="images/dh_1.png" border= "0 "/>&nbsp首页</a>
		</li>
		<li>
			<a class="li" href="#" ><img src="images/dh_2.png" border= "0 "/>&nbsp商店公告</a>
		</li>
		
		<li>
			<a class="li" href="product.jsp" ><img src="images/dh_3.png" border= "0 "/>&nbsp全部商品</a>
		</li>
		
		<li>
			<a class="li" href="#" ><img src="images/dh_4.png" border= "0 "/>&nbsp付款方式</a>
		</li>
		
		<li>
			<a class="li" href="#"><img src="images/dh_5.png" border= "0 "/>&nbsp关于我们</a>
		</li>
		
		<li>
			<a class="li" href="#" ><img src="images/dh_6.png" border= "0 "/>&nbsp在线留言</a>
		</li>
		

		</ul>
	</div>
	
	<div id="search">
		<form id="form1" name="search" method="post" action="SearchServlet">
			<input type="text" name="textfield" style="color:#a4a4a4;vertical-align:middle;" value="请输入关键字"  onfocus="this.value=''" />&nbsp
			<input name="imageField" type="image" align="absmiddle" src="images/search.gif" />
		</form>
	</div>