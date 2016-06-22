package pag;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UPloadJpanel extends JPanel{
	JButton button=new JButton("上传");
	public  UPloadJpanel(){
		Container container=new Container();
		container.setLayout(new BorderLayout());
		container.add(button);
		ButtonAction ba=new ButtonAction();
		button.addActionListener(ba);
		this.add(container);
	}
}
class ButtonAction extends JFrame  implements ActionListener {
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULE_HEIGHT=400;
	JTextField field1=new JTextField();
	JTextField field2=new JTextField();
	JTextField field3=new JTextField();
	JTextField field4=new JTextField();
	JLabel label1=new JLabel("名称：");
	JLabel label2=new JLabel("描述：");
	JLabel label3=new JLabel("类型：");
	JLabel lable4=new JLabel("路径：");
	public void actionPerformed(ActionEvent e) {
		chooser=new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		JButton b1=new JButton("...");
		JButton b2=new JButton("完成");
		b1.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent event)
			  {
			    int result =chooser.showOpenDialog(null);
			 
			    if(result==JFileChooser.APPROVE_OPTION)
			    {
			     String name=chooser.getSelectedFile().getPath();
			    // label.setIcon(new ImageIcon(name));
			     field4.setText(name);
			     System.out.println(name);
			    }
			 
			  }
			 
			});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				String name=field1.getText();
				String description=field2.getText();
				String type=field3.getText();
				String path=field4.getText();
				Uploadphoto.upload( name, description, type, path);
			}
		});
		frame.add(panel);
		panel.setLayout(new GridLayout(2,5,3,3));
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(label3);
		panel.add(field3);
		panel.add(field4);
		panel.add(field4);
		panel.add(b1);
		panel.add(b2);
		frame.setSize(500, 200);
		frame.setTitle("选择路径");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
