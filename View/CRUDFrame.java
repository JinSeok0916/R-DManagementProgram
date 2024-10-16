package View;

import java.awt.Color;
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

public class CRUDFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JLabel p1Label1 = new JLabel("        R&D Management Program");
	List p1List1 = new List();
	JButton p1btn1 = new JButton("선택수정");
	JButton p1btn2 = new JButton("선택삭제");
	JButton p1btn3 = new JButton("추가");
	JLabel logo = new JLabel("");
	int selNum = 0;
	_DBDAO DAO = null;
	
	public CRUDFrame() {
		this.setBounds(200,75,865,890);
		// 패널 나누기
		panel1.setLayout(null);
		p1Label1.setBounds(225,50,400,100);
		p1Label1.setBorder(new LineBorder(Color.black));
		panel1.add(p1Label1);
		p1List1.setBounds(175,175,500,450);
		panel1.add(p1List1);
		p1btn1.setBounds(175,625,250,50);
		panel1.add(p1btn1);
		p1btn2.setBounds(425,625,250,50);
		panel1.add(p1btn2);
		p1btn3.setBounds(175,675,500,50);
		panel1.add(p1btn3);
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("imgs/LogoNewNew2.png"));
		panel1.add(logo);
		this.add(panel1);
		
//		.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p1btn1) {
			DAO.searchNum(selNum);
			
		} else if (e.getSource() == p1btn2) {
			DAO.searchNum(selNum);
			
		} else {
			DAO.insert();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		selNum = p1List1.getSelectedIndex();
	}
}
