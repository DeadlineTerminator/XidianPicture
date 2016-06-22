//这是一个控制器，主要完成对用户身份的验证
//控制器本身不会完成业务逻辑，主要是去调用model完成对数据处理
package com.ghl.controller;

import java.io.IOException;
import java.util.*;
import com.ghl.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginClServlet
 */
@WebServlet("/LoginClServlet")
public class LoginClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//得到用户名和密码
		String u=request.getParameter("username");
		String p=request.getParameter("pswd");
		//使用model（UserBeanCl）完成对用户的验证
		//创建一个UserBeanCl对象
		UserBeanCl ubc=new UserBeanCl();
		//调用方法
		if(ubc.checkAdmin(u, p)){
			//System.out.println("这是用控制器完成验证的");
			//转向：停一下，重新发起请求
			//response.sendRedirect("manage.jsp");
			//效率不高，经常用转发:效率高，同时request中的对象还可以在下一个页面使用
			//在跳转到manage.jsp页面时，就要把要显示的数据准备好
			
			ArrayList al=ubc.getUsersByPage(1);
			int pageCount=ubc.getpageCount();
			//将al，pageCount放入request中
			request.setAttribute("result", al);
			request.setAttribute("pageCount", pageCount+"");
			request.setAttribute("pageNow", 1+"");
			request.getRequestDispatcher("manage.jsp").forward(request, response);
			
		}
		else if(ubc.checkUser(u, p)){
			//response.sendRedirect("user.jsp?username="+u);
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}
		else{
		//	response.sendRedirect("login.jsp?mess=该用户不存在或密码错误");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
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
