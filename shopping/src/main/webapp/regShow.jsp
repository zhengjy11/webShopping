<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userinfo" class="com.model.Userinfo" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册信息</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	
	<div id="page">
		<div id="header">
			<jsp:include page="header.jsp" />      
       	</div>
       	
       	<div id="div_reg">
       		<h3>恭喜您注册成功！以下为您的注册信息：</h3><br>
       		<hr size=1>  
				<table align="center">
					<tr>
						<td>用户名：
						</td>
						<td><jsp:getProperty property="username" name="userinfo"/>
						</td>
					</tr>
					<tr>
						<td>密码：
						</td>
						<td><jsp:getProperty property="pwd" name="userinfo"/>
						</td>
					</tr>
					<tr>
						<td>性别：
						</td>
						<td><jsp:getProperty property="sex" name="userinfo"/>
						</td>
					</tr>
					<tr>
						<td>兴趣：
						</td>
						<td><jsp:getProperty property="hobby" name="userinfo"/>
						</td>
					</tr>
				</table>
       		
        </div>
       	
       	<div id="footer">
			<jsp:include page="bottom.jsp" />  
		</div>
	</div>	
</body>
</html>