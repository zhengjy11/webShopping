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

/**
 * Servlet implementation class ShowProductServlet
 */
@WebServlet("/ShowProductServlet")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductServlet() {
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
		String value = request.getParameter("name");
		int page;
		if(value == null) {
			page=1;
		}else {
			page = Integer.parseInt(request.getParameter("name")) ;
		}
		
		//验证数据
		//处理数据：连接数据库，获取商品信息,获取商品总条数
		String sql="select id,name,img,price,sale from product";
		DataProcess dataProcess = new DataProcess();
		Vector<Vector<String>> rows = dataProcess.getData(sql);
		
		String begin = String.valueOf((page-1)*9);
		String c= "9";
		String sql2="select id,name,img,price,sale from product limit "+begin+","+c+"";
		DataProcess dataProcess2 = new DataProcess();
		Vector<Vector<String>> rows2 = dataProcess2.getData(sql2);
		
		request.setAttribute("products1", rows);
		request.setAttribute("products", rows2);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
