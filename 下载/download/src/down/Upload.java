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
			    
			    JFrame jf=new JFrame("�ļ��Ի���");
			    JButton save;
			    JFileChooser fc=new JFileChooser();
				Container container=jf.getContentPane();
				container.setLayout(new FlowLayout());
				save=new JButton("����ͼƬ");
				save.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								int select=fc.showSaveDialog(jf);
								if(select==JFileChooser.APPROVE_OPTION){
									//ѡ���Ƿ�Ϊȷ��
									File file=fc.getSelectedFile();//����ѡ�񴴽��ļ�����
									//����Ļ����ʾ���ļ����ļ���
									download(file);
									System.out.println("�ļ�"+file.getName()+"������");
								}
								else{
									System.out.println("���������ȡ��");
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
		             //�ӱ���Ӳ��Ӳ�̶�ȡһ��ͼƬ���浽���ݿ�
		        		Connection con=DriverManager.getConnection(url,userName,password);
		        		InputStream in=new FileInputStream("C:/Users/user1/Pictures/ͼƬ/6624cdf9d72a60593b5331332b34349b033bba07.jpg");
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
		            	 
		            //�����ݿ��ȡͼƬ���浽����Ӳ��
		            	 
		            try(Connection con=DriverManager.getConnection(url,userName,password);
		            PreparedStatement ps =con.prepareStatement("select * from picture2 where id=?"))
		            {
		             ps.setInt(1,10);
		             ResultSet rs=ps.executeQuery();
		             rs.next();    //�����ָ���һ��
		             InputStream in=rs.getBinaryStream("image");
		             byte[] b=new byte[in.available()];    //�½�����ͼƬ���ݵ�byte����
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








