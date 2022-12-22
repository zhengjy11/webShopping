package com.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.DataProcess;
import com.model.Userinfo;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//接收数据
		String strName = request.getParameter("userName");
		String strPwd = request.getParameter("pwd");
		String strPwd1 = request.getParameter("pwd1");
		String strSex = request.getParameter("sex");
		String strHobby[] = request.getParameterValues("hobby");
		//验证数据
		if(strName==null || strName.equals("") || strPwd==null ||strPwd.equals("") || strSex==null ||strSex.equals("") || strHobby==null ||strHobby.equals("")) {
			request.setAttribute("mess1", "内容不能为空!");
			RequestDispatcher dispatcher =  request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
					
			return;
		}
		
		if(!strPwd.equals(strPwd1)) {
			request.setAttribute("mess1", "两次密码输入不一致!");
			request.getRequestDispatcher("reg.jsp").forward(request, response);
			return;
		}
		
		//验证用户名是否存在
		String sql1="select * from userinfo1 where username='"+strName+"'";
		DataProcess data = new DataProcess();
		Vector<Vector<String>> rows = data.getData(sql1);
		
		if(rows.size()!=0) {
			request.setAttribute("mess1", "用户名已存在！");
			RequestDispatcher dispatcher =  request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		
		//处理数据:在数据库新增数据，并跳转到regShow.jsp并提示
		//String[]->String
		String strHobbies="";
		for(int i=0;i<strHobby.length;i++){
			strHobbies+=strHobby[i]+",";
		}
		strHobbies=strHobbies.substring(0,strHobbies.length()-1);
		
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername(strName);
		userinfo.setPwd(strPwd);
		userinfo.setSex(strSex);
		userinfo.setHobby(strHobbies);
		
		
		String sql="INSERT INTO userinfo1(username,password,sex,interest) values('"+strName+"','"+strPwd+"','"+strSex+"','"+strHobbies+"')";
		DataProcess data1 = new DataProcess();
		int count = data1.update(sql);
		
		request.setAttribute("userinfo", userinfo);
		request.getRequestDispatcher("regShow.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
