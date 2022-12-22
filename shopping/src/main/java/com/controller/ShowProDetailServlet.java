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
 * Servlet implementation class ShowProDetailServlet
 */
@WebServlet("/ShowProDetailServlet")
public class ShowProDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProDetailServlet() {
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
		String productid = request.getParameter("productid");
		//验证数据
		//处理数据
		String sql="select * from product where id="+productid;
		DataProcess data = new DataProcess();
		Vector<Vector<String>> rows=data.getData(sql);
		Product product = new Product();
		product.setId(Integer.parseInt(rows.get(0).get(0)));
		product.setName(rows.get(0).get(1));
		product.setSort(Integer.parseInt(rows.get(0).get(2)));
		product.setPrice(Float.parseFloat(rows.get(0).get(3)));
		product.setOneprice(Float.parseFloat(rows.get(0).get(4)));
		product.setImg(rows.get(0).get(5));
		product.setSale(Integer.parseInt(rows.get(0).get(6)));
		product.setFace(rows.get(0).get(7));
		product.setBody(rows.get(0).get(8));
		product.setLength(rows.get(0).get(9));
		product.setQuantity(Integer.parseInt(rows.get(0).get(10)));
		product.setSource(rows.get(0).get(11));
		
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("item.jsp");
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
