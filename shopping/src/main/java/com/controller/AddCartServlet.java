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
import com.model.Product;
import com.model.ProductCart;
import com.model.Userinfo;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
		String quantity = request.getParameter("quantity");
		//验证数据	
		//处理数据将商品信息存入到购物车数据表中	
		String sql="select * from product where id="+id;
		DataProcess data = new DataProcess();
		Vector<Vector<String>> rows=data.getData(sql);
		ProductCart productCart = new ProductCart();
		productCart.setId(Integer.parseInt(rows.get(0).get(0)));
		productCart.setName(rows.get(0).get(1));
		productCart.setPrice(Float.parseFloat(rows.get(0).get(3)));
		productCart.setQuantity(Integer.parseInt(quantity));
		productCart.setSum(Float.parseFloat(rows.get(0).get(4)));
		
		String idCart = rows.get(0).get(0);
		String nameCart = rows.get(0).get(1);
		String priceCart = rows.get(0).get(3);
		String quantityCart = quantity;
		String sumCart =String.valueOf(Integer.parseInt(quantityCart)*Float.parseFloat(priceCart)) ;
		
		String sql1="INSERT INTO productcart(id,name,price,quantity,sum) values(null,'"+nameCart+"','"+priceCart+"','"+quantityCart+"','"+sumCart+"')";
		DataProcess data1 = new DataProcess();
		int count = data1.update(sql1);
		
		String sql2="select id,name,price,quantity,sum from productcart";
		DataProcess dataProcess = new DataProcess();
		Vector<Vector<String>> rows2 = dataProcess.getData(sql2);
		
		HttpSession session = request.getSession();
		session.setAttribute("productCart", rows2);
		response.sendRedirect("cart_view.jsp");
		
		/*
		 * request.setAttribute("productCart", rows2); RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("cart_view.jsp"); dispatcher.forward(request,
		 * response);
		 */
		
				
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
