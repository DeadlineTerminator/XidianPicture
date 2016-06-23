package com.ghl.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ghl.model.PictureBean;
import com.ghl.model.*;

/**
 * Servlet implementation class PictureClServlet
 */
@WebServlet("/PictureClServlet")
public class PictureClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//String txt="ghl";
    public PictureClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  /*  public void setTxt(String a){
    	txt=a;
    }
    public String getTxt(){
    	return txt;
    }*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//	String s_pageNow=request.getParameter("pageNow");
		//	int pageNow=Integer.parseInt(s_pageNow);
			//调用UserBeanCl
			String s=request.getParameter("q");
		//	if(s==null){
			//	System.out.println(this.getTxt());
				//s=this.getTxt();
				//request.getRequestDispatcher("wel.jsp").forward(request, response);
			//}
		//	System.out.println(s);
			if(s!=null){
				s = new String(s.getBytes("ISO8859-1"),"UTF-8");
				//this.setTxt(s);
				 PictureBeanCl pbc=new PictureBeanCl();
					//UserBeanCl  ubc=new UserBeanCl();
					ArrayList al=pbc.getPicturesByPage(1,s);
					int pageCount=pbc.getpageCount(s);
					//将al，pageCount放入request中
					request.setAttribute("result", al);
					request.setAttribute("pageCount", pageCount+"");
					request.setAttribute("pageNow",1+"");
					request.setAttribute("search", s);
					//重新跳转回manage.jsp
					//request.getRequestDispatcher("/DownloadClServlet").forward(request, response);
					request.getRequestDispatcher("view.jsp").forward(request, response);
					
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
