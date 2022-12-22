package com.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.DataProcess;
import com.model.Userinfo;

/**
 * Servlet implementation class LoginServelt
 */
@WebServlet("/LoginServelt")
public class LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelt() {
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
		String strName = request.getParameter("useName");
		String strPwd = request.getParameter("pwd");
		
		//验证数据
		if(strName==null || strName.equals("") || strPwd==null ||strPwd.equals("")) {
			request.setAttribute("mess", "不能为空!");
			RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			
			return;
		}
		
		//处理数据:1.连接数据库验证用户名密码。如果验证不通过，说明登录失败，跳转到login.jsp并提示
		String sql="select * from userinfo1 where username='"+strName+"' and password='"+strPwd+"'";
		DataProcess data = new DataProcess();
		Vector<Vector<String>> rows = data.getData(sql);
		
		if(rows.size()==0) {
			request.setAttribute("mess", "用户名或密码不正确");
			RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return;
		}
			//2.验证通过，表示登录成功。将用户信息封装到模型（Userinfo对象）中，并设置其生命周期为session，最后跳转到index.jsp并显示用户名
			Userinfo userinfo = new Userinfo();
			userinfo.setUsername(strName);
			userinfo.setPwd(strPwd);
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", userinfo);
			response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
