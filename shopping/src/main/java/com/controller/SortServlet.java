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
import com.model.Product;

/**
 * Servlet implementation class sortServelt
 */
@WebServlet("/SortServlet")
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortServlet() {
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
		String id = request.getParameter("id");
		//验证数据
		//处理数据
		String sql="select * from product where sort="+id;
		DataProcess data = new DataProcess();
		Vector<Vector<String>> rows=data.getData(sql);
		/*
		 * Product product1 = new Product();
		 * product1.setId(Integer.parseInt(rows.get(0).get(0)));
		 * product1.setName(rows.get(0).get(1));
		 * product1.setSort(Integer.parseInt(rows.get(0).get(2)));
		 * product1.setPrice(Float.parseFloat(rows.get(0).get(3)));
		 * product1.setOneprice(Float.parseFloat(rows.get(0).get(4)));
		 * product1.setImg(rows.get(0).get(5));
		 * product1.setSale(Integer.parseInt(rows.get(0).get(6)));
		 * product1.setFace(rows.get(0).get(7)); product1.setBody(rows.get(0).get(8));
		 * product1.setLength(rows.get(0).get(9));
		 * product1.setQuantity(Integer.parseInt(rows.get(0).get(10)));
		 * product1.setSource(rows.get(0).get(11));
		 */
				
		request.setAttribute("productsSort", rows);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sort.jsp");
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
