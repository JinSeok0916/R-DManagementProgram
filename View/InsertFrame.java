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
import javax.swing.border.LineBorder;

import DAO._DBDAO;

public class InsertFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JLabel p1Label1 = new JLabel("<html><center>R&D Management Program</center></html>");
	List p1List1 = new List();
	JButton p1btn1 = new JButton("선택수정");
	JButton p1btn2 = new JButton("선택삭제");
	JButton p1btn3 = new JButton("추가");
	JLabel logo = new JLabel("");
	int selNum = 0;
	_DBDAO DAO = null;
	
	public InsertFrame() {
		this.setBounds(325,375,600,300);
		// 패널 나누기
		panel1.setLayout(null);
		p1Label1.setBounds(140,0,400,50);
		p1Label1.setFont(new Font("나눔명조",Font.BOLD,25));
		panel1.add(p1Label1);
		
//		logo.setBounds(25,25,800,800);
//		logo.setIcon(new ImageIcon("imgs/LogoNewNew2.png"));
//		panel1.add(logo);
		this.add(panel1);
		
//		.addActionListener(this);
		
		this.setVisible(true);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p1btn1) {
			
		} else if (e.getSource() == p1btn2) {
			
		} else {
		}
	}

	public void itemStateChanged(ItemEvent e) {
		selNum = p1List1.getSelectedIndex();
	}
}
