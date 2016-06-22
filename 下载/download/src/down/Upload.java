package down;
	import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.*;
	import java.sql.*;
	import javax.swing.*;

	public class Upload {
		
		 
		   String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		   String userName="sa"; 
		   String password="19950713";  
		   String url="jdbc:sqlserver://localhost:1433;DatabaseName=example";  
		   public void GUI()
		   {
			    
			    JFrame jf=new JFrame("文件对话框");
			    JButton save;
			    JFileChooser fc=new JFileChooser();
				Container container=jf.getContentPane();
				container.setLayout(new FlowLayout());
				save=new JButton("保存图片");
				save.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								int select=fc.showSaveDialog(jf);
								if(select==JFileChooser.APPROVE_OPTION){
									//选择是否为确认
									File file=fc.getSelectedFile();//根据选择创建文件对象
									//在屏幕上显示打开文件的文件名
									download(file);
									System.out.println("文件"+file.getName()+"被保存");
								}
								else{
									System.out.println("保存操作被取消");
								}
							}
					
						});
				container.add(save);
				jf.setVisible(true);
				jf.setSize(650, 450);
					
				}
		   
		   public void create()  {
		        try {
					Class.forName(driverName);
					//System.out.print("!!!!!!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//System.out.print("!!!!!!");
				}
		        try(
		             //从本地硬盘硬盘读取一张图片保存到数据库
		        		Connection con=DriverManager.getConnection(url,userName,password);
		        		InputStream in=new FileInputStream("C:/Users/user1/Pictures/图片/6624cdf9d72a60593b5331332b34349b033bba07.jpg");
		        		PreparedStatement ps=con.prepareStatement("insert into picture2 values(?,?,?,?,?)"))
		        {
		        	 
		        	ps.setInt(1,10);
		        	ps.setString(2,"photo");
		        	ps.setString(3,"dingxiang");
		        	ps.setString(4,"sushe");
		            ps.setBinaryStream(5, in, in.available());
		            ps.executeUpdate();

		            }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
		   }
		             
		             public void download(File file){
		            	 
		            //从数据库读取图片保存到本地硬盘
		            	 
		            try(Connection con=DriverManager.getConnection(url,userName,password);
		            PreparedStatement ps =con.prepareStatement("select * from picture2 where id=?"))
		            {
		             ps.setInt(1,10);
		             ResultSet rs=ps.executeQuery();
		             rs.next();    //将光标指向第一行
		             InputStream in=rs.getBinaryStream("image");
		             byte[] b=new byte[in.available()];    //新建保存图片数据的byte数组
		             in.read(b);
		            
		             OutputStream out=new FileOutputStream(file);
		             out.write(b);
		             out.flush();
		             out.close();
		         } 
		         catch (Exception e) {
		             System.out.println("Error::"+e);
		         }
		     }
		   public static void main(String[] args) throws ClassNotFoundException 
		   {
			    Upload up=new Upload();
			    up.create();
			    up.GUI();
		   }
		 }








