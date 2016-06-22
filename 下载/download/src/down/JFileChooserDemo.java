package down;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class JFileChooserDemo extends JFrame implements ActionListener{
	JFileChooser fc=new JFileChooser();
	JButton open,save;
	public JFileChooserDemo(){
		Container container=this.getContentPane();
		container.setLayout(new FlowLayout());
		this.setTitle("文件对话框演示程序");
		open=new JButton("打开文件");
		save=new JButton("保存文件");
		open.addActionListener(this);
		save.addActionListener(this);
		container.add(open);
		container.add(save);
		this.setVisible(true);
		this.setSize(650, 450);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFileChooserDemo fc=new JFileChooserDemo();
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
				//在屏幕上显示打开文件的文件名
				System.out.println("文件"+file.getName()+"被保存");
			}
			else{
				System.out.println("保存操作被取消");
			}
			
		}
	}

}
