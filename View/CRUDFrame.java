package View;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
	int selNum = 0;
	_DBDAO DAO = null;
	
	public CRUDFrame() {
		this.setBounds(200,200,500,500);
		// 패널 나누기
		panel1.setLayout(null);
		p1Label1.setBounds(150,0,200,25);
		p1Label1.setBorder(new LineBorder(Color.black));
		p1btn1.setBounds(150,300,100,50);
		p1btn2.setBounds(250,300,100,50);
		p1btn3.setBounds(150,350,200,50);
		p1List1.setBounds(150,75,200,250);
		panel1.add(p1Label1);
		panel1.add(p1btn1);
		panel1.add(p1btn2);
		panel1.add(p1btn3);
		panel1.add(p1List1);
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
