package com.ghl.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ghl.*;
import com.ghl.model.PictureBean;
import com.ghl.model.PictureBeanCl;
/**
 * Servlet implementation class UploadClServlet
 */
@WebServlet("/UploadClServlet")
public class UploadClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("picname");
		String des=request.getParameter("description");
		String type=request.getParameter("pictype");
		String picture=request.getParameter("picture");
		name=new String(name.getBytes("ISO8859-1"), "UTF-8");
		des=new String(des.getBytes("ISO8859-1"), "UTF-8");
		type=new String(type.getBytes("ISO8859-1"), "UTF-8");
		picture=new String(picture.getBytes("ISO8859-1"), "UTF-8");
		PictureBeanCl pic=new PictureBeanCl();
		if(pic.addPicture(name,des,type,picture))
		{
			System.out.println("Success!");
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
