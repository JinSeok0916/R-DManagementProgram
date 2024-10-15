package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ManageFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JLabel p1Label1 = new JLabel("        R&D Management Program");
	List p1List1 = new List();
	JButton p1btn1 = new JButton("회사추가");
	JButton p1btn2 = new JButton("상세설정");
	JButton p1btn3 = new JButton("회사삭제");
	
	public ManageFrame() {
		this.setBounds(200,200,500,500);
		// 패널 나누기
		panel1.setLayout(null);
		p1Label1.setBounds(150,0,200,25);
		p1Label1.setBorder(new LineBorder(Color.black));
		p1btn1.setBounds(50,350,100,50);
		p1btn2.setBounds(200,350,100,50);
		p1btn3.setBounds(350,350,100,50);
		p1List1.setBounds(100,75,300,250);
		panel1.add(p1Label1);
		panel1.add(p1btn1);
		panel1.add(p1btn2);
		panel1.add(p1btn3);
		panel1.add(p1List1);
		this.add(panel1);
		
		p1btn2.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p1btn1) {
			
		} else if (e.getSource() == p1btn2) {
			new CRUDFrame();
			this.setVisible(false);
		}
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
