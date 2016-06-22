package com.ghl.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ghl.model.*;
/**
 * Servlet implementation class UsersClServlet
 */
@WebServlet("/UsersClServlet")
public class UsersClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try{
			
			int pageNow=Integer.parseInt(request.getParameter("pageNow"));
			//调用UserBeanCl
			UserBeanCl  ubc=new UserBeanCl();
			ArrayList al=ubc.getUsersByPage(pageNow);
			int pageCount=ubc.getpageCount();
			//将al，pageCount放入request中
			request.setAttribute("result", al);
			request.setAttribute("pageCount", pageCount+"");
			request.setAttribute("pageNow", pageNow+"");
			//重新跳转回manage.jsp
			request.getRequestDispatcher("manage.jsp").forward(request, response);;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
