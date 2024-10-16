package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JLabel p1Label1 = new JLabel("R&D Management");
	JLabel p1Label2 = new JLabel("Program");
	JButton p1btn1 = new JButton("사업개요");
	JButton p1btn2 = new JButton("참여기업관리");
	JLabel logo = new JLabel("");
	
	public MainFrame() {
		this.setBounds(200,75,865,890);
		
		// 패널 나누기
		panel1.setLayout(null);
		p1Label1.setBounds(220,50,1000,100);
		p1Label1.setFont(new Font("나눔명조",Font.BOLD,50));
		panel1.add(p1Label1);
		p1Label2.setBounds(320,75,1000,200);
		p1Label2.setFont(new Font("나눔명조",Font.BOLD,50));
		panel1.add(p1Label2);
		p1btn1.setBounds(225,650,200,100);
		panel1.add(p1btn1);
		p1btn2.setBounds(425,650,200,100);
		panel1.add(p1btn2);
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("imgs/LogoNewNew2.png"));
		panel1.add(logo);
		this.add(panel1);
		
		p1btn1.addActionListener(this);
		p1btn2.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p1btn1) {
//			System.out.println("1번버튼");
			new OverviewFrame();
			this.setVisible(false);
		} else if (e.getSource() == p1btn2) {
//			System.out.println("2번버튼");
			new ManageFrame();
			this.setVisible(false);
		}
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
