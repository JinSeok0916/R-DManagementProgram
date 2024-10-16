package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ManageFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JLabel p1Label1 = new JLabel("<html><center>R&D Management Program</center></html>");
	List p1List1 = new List();
	JButton p1btn1 = new JButton("회사추가");
	JButton p1btn2 = new JButton("상세설정");
	JButton p1btn3 = new JButton("회사삭제");
	JLabel logo = new JLabel("");
	
	public ManageFrame() {
		this.setBounds(200,75,865,890);
		// 패널 나누기
		panel1.setLayout(null);
		p1Label1.setBounds(260,50,400,100);
		p1Label1.setFont(new Font("나눔명조",Font.BOLD,25));
		panel1.add(p1Label1);
		p1List1.setBounds(175,175,500,450);
		p1List1.setFont(new Font("나눔명조",Font.PLAIN,18));
		panel1.add(p1List1);
		p1btn1.setBounds(175,625,167,50);
		panel1.add(p1btn1);
		p1btn2.setBounds(342,625,167,50);
		panel1.add(p1btn2);
		p1btn3.setBounds(509,625,166,50);
		panel1.add(p1btn3);
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("imgs/LogoNewNew2.png"));
		panel1.add(logo);
		this.add(panel1);
		
		p1btn1.addActionListener(this);
		p1btn2.addActionListener(this);
		p1btn3.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p1btn1) {
			new InsertFrame();
		} else if (e.getSource() == p1btn2) {
			new CRUDFrame();
			this.setVisible(false);
		} else if (e.getSource() == p1btn3) {
			new DeleteFrame();
//			this.setVisible(false);
			
		}
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
