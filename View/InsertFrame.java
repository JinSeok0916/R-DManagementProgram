package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO._DBDAO;

public class InsertFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JLabel p1Label1 = new JLabel("<html><center>R&D Management Program</center></html>");
	List p1List1 = new List();
	JButton p1btn1 = new JButton("확인");
	JTextField p1tf1 = new JTextField();
	JTextField p1tf2 = new JTextField();
	JTextField p1tf3 = new JTextField();
	JTextField p1tf4 = new JTextField();
	
	int selNum = 0;
	_DBDAO DAO = null;
	
	public InsertFrame() {
		this.setBounds(325,375,600,300);
		// 패널 나누기
		panel1.setLayout(null);
		p1Label1.setBounds(140,0,400,50);
		p1Label1.setFont(new Font("나눔명조",Font.BOLD,25));
		panel1.add(p1Label1);
		
		p1tf1.setBounds(55,100,100,50);
		panel1.add(p1tf1);
		p1tf2.setBounds(180,100,100,50);
		panel1.add(p1tf2);
		p1tf3.setBounds(305,100,100,50);
		panel1.add(p1tf3);
		p1tf4.setBounds(430,100,100,50);
		panel1.add(p1tf4);
		
		p1btn1.setBounds(240,175,100,30);
		p1btn1.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(p1btn1);
		
		this.add(panel1);
		
		p1btn1.addActionListener(this);
		
		this.setVisible(true);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p1btn1) {
			// 회사추가 메서드
			
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}

	public void itemStateChanged(ItemEvent e) {
		selNum = p1List1.getSelectedIndex();
	}
}
