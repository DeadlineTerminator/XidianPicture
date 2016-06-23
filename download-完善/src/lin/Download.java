package lin;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.*;

 
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;


public class Download implements Action {
	private  Statement sm=null;
	private  ResultSet rs=null;
	private  Connection ct=null;
	private  int pageSize=3;
	private int rowCount =0;
	private int pageCount=0;
	
	public  ArrayList getpicturesByPage(int pageNow){
		ArrayList al=new ArrayList();
		//鑻ヨ繑鍥瀝s,鍒欏叧闂暟鎹簱灏变細鍑洪敊
		//鎶婃煡璇㈢粨鏋滐紝褰撳仛UserBean鐨勫疄渚嬪璞�
		try{
			 ct=new ConnDB().getConn();
			 sm=ct.createStatement();
		  rs=sm.executeQuery("select top "+pageSize+" * from picture where id not in (select top "+pageSize*(pageNow-1)+" +id from picture)");
		 //寮�濮嬪皢rs灏佽鍒癮rraylist
		 while(rs.next()){
			 Picture pi=new Picture();
			 pi.setpictureid(rs.getInt(1));
			 pi.setname(rs.getString(2));
			 pi.setdescription(rs.getString(3));
			 pi.settype(rs.getString(4));
			 pi.setpath(rs.getString(5));
			 al.add(pi);
		 }
		
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.close();
			
		}
		return al;
		
	}
	public  void close(){
		try{
			if(rs!=null){
				rs.close();
				rs=null;//鍔犻�熻祫婧愮殑閲婃斁
			}
			if(sm!=null){
				sm.close();
				sm=null;
			}
			if(ct!=null){
				ct.close();
				ct=null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void copyFile(String oldPath, String newPath) throws IOException{
		 FileInputStream fin = new FileInputStream(oldPath);
				     FileOutputStream fout = new FileOutputStream(newPath);
				  
				     FileChannel fcin = fin.getChannel();
				     FileChannel fcout = fout.getChannel();
				  
				     ByteBuffer buffer = ByteBuffer.allocateDirect( 1024 );
				  
				     while (true) {
				       buffer.clear();
				  
				       int r = fcin.read( buffer );
				  
				       if (r==-1) {
				         break;
				       }
				  
				       buffer.flip();
				  
				       fcout.write( buffer );
				     }
				  }
	public class JFileChooserDemo extends JFrame {//implements ActionListener{
		JFileChooser fc=new JFileChooser();
		//JButton save;
		String path;
		public JFileChooserDemo(String path){
			int select=fc.showSaveDialog(this);
			if(select==JFileChooser.APPROVE_OPTION){
				//选择是否为确认
				File file=fc.getSelectedFile();//根据选择创建文件对象
				String s=file.getAbsolutePath();
				String s1=s.replace('\\','/');
				try {
					copyFile(path,s1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//在屏幕上显示打开文件的文件名
				//System.out.println("文件"+file.getName()+"被保存");
			}
			else{
				System.out.println("保存操作被取消");
			}
		}
			/*this.path=path;
			Container container=this.getContentPane();
			container.setLayout(new FlowLayout());
			this.setTitle("文件对话框演示程序");
			//open=new JButton("打开文件");
			save=new JButton("保存文件");
			//open.addActionListener(this);
			save.addActionListener(this);
			//container.add(open);
			container.add(save);
			this.setVisible(true);
			this.setSize(650, 450);
		}
		public void actionPerformed(ActionEvent e){
			JButton button=(JButton)e.getSource();
			if(button==open){
				int select=fc.showOpenDialog(this);//显示打开文件对话框
				if(select==JFileChooser.APPROVE_OPTION){
					//选择是否为确认
					File file=fc.getSelectedFile();//根据选择创建文件对象
					//在屏幕上显示打开文件的文件名
					System.out.println("文件"+file.getName()+"被打开");
				}
				else{
					System.out.println("打开操作被取消");
				}
			}
			if(button==save){
				int select=fc.showSaveDialog(this);
				if(select==JFileChooser.APPROVE_OPTION){
					//选择是否为确认
					File file=fc.getSelectedFile();//根据选择创建文件对象
					String s=file.getAbsolutePath();
					String s1=s.replace('\\','/');
					try {
						copyFile(path,s1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//在屏幕上显示打开文件的文件名
					//System.out.println("文件"+file.getName()+"被保存");
				}
				else{
					System.out.println("保存操作被取消");
				}
				
			}
		}*/

	}


	public String execute() throws Exception
	{
		ArrayList al=getpicturesByPage(1);
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getParameter("1").equals("1")){
			Picture p1=(Picture)al.get(0);
			String path1=p1.getpath();
			String path11=path1.replace('\\','/');
			JFileChooserDemo fc=new JFileChooserDemo(path11);
			//C:\Users\Administrator\Desktop\jihuoqi1.png
			return SUCCESS;    
		}
		else if(request.getParameter("1").equals("2")){
			Picture p2=(Picture)al.get(1);
			String path2=p2.getpath();
			String path22=path2.replace('\\','/');
			JFileChooserDemo fc=new JFileChooserDemo(path22);//C:\Users\Administrator\Desktop\jihuoqi1.png
			return SUCCESS;    
		}
		else{
			return ERROR;
		}
		
    }
}
/*	 static public void main( String args[] ){
		 ArrayList al=getpicturesByPage(1);
		 Picture p1=(Picture)al.get(1);
			String path1=p1.getpath();
		 System.out.println(path1);
		 close();
	 }*/
