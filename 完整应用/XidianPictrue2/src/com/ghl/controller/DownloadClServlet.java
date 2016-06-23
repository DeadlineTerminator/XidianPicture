package com.ghl.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ghl.model.PictureBean;
import com.ghl.model.PictureBeanCl;

/**
 * Servlet implementation class DownloadClServlet
 */
public class DownloadClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PictureBeanCl pbc=new PictureBeanCl();
		
		ArrayList al=(ArrayList) request.getSession().getAttribute("result");;
		//request = ServletActionContext.getRequest();
		if(request.getParameter("button").equals("download0")){
			PictureBean p1=(PictureBean)al.get(0);
			String path1=p1.getP();
		    String path11=path1.replace('\\','/');
		    path11="D:/eclipsecode/XidianPictrue2/WebContent/"+path11;
			com.ghl.model.PictureBeanCl.JFileChooserDemo fc=pbc.new JFileChooserDemo(path11);
			//C:\Users\Administrator\Desktop\jihuoqi1.png 
			response.sendRedirect("success.jsp");

		}
		else if(request.getParameter("button").equals("download1")){
			PictureBean p2=(PictureBean)al.get(1);
			String path2=p2.getP();
			String path22=path2.replace('\\','/');
			  path22="D:/eclipsecode/XidianPictrue2/WebContent/"+path22;
			com.ghl.model.PictureBeanCl.JFileChooserDemo fc=pbc.new JFileChooserDemo(path22);//C:\Users\Administrator\Desktop\jihuoqi1.png
			response.sendRedirect("success.jsp"); 
		}
		else if(request.getParameter("button").equals("download2")){
			PictureBean p3=(PictureBean)al.get(2);
			String path3=p3.getP();
			String path33=path3.replace('\\','/');
			  path33="D:/eclipsecode/XidianPictrue2/WebContent/"+path33;
			com.ghl.model.PictureBeanCl.JFileChooserDemo fc=pbc.new JFileChooserDemo(path33);//C:\Users\Administrator\Desktop\jihuoqi1.png
			response.sendRedirect("success.jsp"); 
		}
		else{
			response.sendRedirect("error.jsp");
		}
		
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
