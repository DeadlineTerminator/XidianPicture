package picture;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UploadClServlet")
public class UploadClServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public UploadClServlet(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("picname");
		String des=request.getParameter("description");
		String type=request.getParameter("pictype");
		String picture=request.getParameter("picture");
		PictureBean pic=new PictureBean();
		if(pic.pictureAdd(name,des,type,picture))
			System.out.println("Success!");
			
		}
}