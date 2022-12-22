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

/**
 * Servlet implementation class MoreServlet
 */
@WebServlet("/MoreServlet")
public class MoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String sql="select * from product order by sale desc limit 0,4";
		DataProcess dataProcess = new DataProcess();
		Vector<Vector<String>> rows = dataProcess.getData(sql);
		
		HttpSession session = request.getSession();
		session.setAttribute("hotProducts", rows);
		response.sendRedirect("index.jsp");
		
		/*
		 * request.setAttribute("hotProducts", rows); RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("index.jsp"); dispatcher.forward(request,
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
