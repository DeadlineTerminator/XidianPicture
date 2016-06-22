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
		this.setTitle("�ļ��Ի�����ʾ����");
		open=new JButton("���ļ�");
		save=new JButton("�����ļ�");
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
			int select=fc.showOpenDialog(this);//��ʾ���ļ��Ի���
			if(select==JFileChooser.APPROVE_OPTION){
				//ѡ���Ƿ�Ϊȷ��
				File file=fc.getSelectedFile();//����ѡ�񴴽��ļ�����
				//����Ļ����ʾ���ļ����ļ���
				System.out.println("�ļ�"+file.getName()+"����");
			}
			else{
				System.out.println("�򿪲�����ȡ��");
			}
		}
		if(button==save){
			int select=fc.showSaveDialog(this);
			if(select==JFileChooser.APPROVE_OPTION){
				//ѡ���Ƿ�Ϊȷ��
				File file=fc.getSelectedFile();//����ѡ�񴴽��ļ�����
				//����Ļ����ʾ���ļ����ļ���
				System.out.println("�ļ�"+file.getName()+"������");
			}
			else{
				System.out.println("���������ȡ��");
			}
			
		}
	}

}
