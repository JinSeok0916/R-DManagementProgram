package View;

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


public class ManageFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JButton p1Label1 = new JButton("<html><center>R&D Management Program</center></html>");
	List p1List1 = new List();
	JButton p1btn1 = new JButton("회사추가");
	JButton p1btn2 = new JButton("상세설정");
	JButton p1btn3 = new JButton("회사삭제");
	JButton p1btn4 = new JButton("←");
	JButton p1btn5 = new JButton("Ⅹ");
	JLabel logo = new JLabel("");
	
	public ManageFrame() {
		this.setBounds(200,75,865,890);
		// 패널 나누기
		panel1.setLayout(null);
		
		
		
		p1Label1.setBounds(175,135,400,40);
		p1Label1.setFont(new Font("나눔명조",Font.BOLD,25));
		panel1.add(p1Label1);
		p1List1.setBounds(175,175,500,450);
		p1List1.setFont(new Font("나눔명조",Font.PLAIN,30));
		panel1.add(p1List1);
		p1btn1.setBounds(175,625,167,50);
		p1btn1.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(p1btn1);
		p1btn2.setBounds(342,625,167,50);
		p1btn2.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(p1btn2);
		p1btn3.setBounds(509,625,166,50);
		p1btn3.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(p1btn3);
		p1btn4.setBounds(575,135,50,40);
		p1btn4.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(p1btn4);
		p1btn5.setBounds(625,135,50,40);
		p1btn5.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(p1btn5);
		
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		panel1.add(logo);
		this.add(panel1);
		
		p1Label1.addActionListener(this);
		p1btn1.addActionListener(this);
		p1btn2.addActionListener(this);
		p1btn3.addActionListener(this);
		p1btn4.addActionListener(this);
		p1btn5.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p1btn1) {
			new InsertFrame();
		} else if (e.getSource() == p1btn2) {
			new CRUDFrame();
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		} else if (e.getSource() == p1btn3) {
//			new DeleteFrame();
		} else if (e.getSource() == p1btn4) {
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			new MainFrame();
		} else if (e.getSource() == p1btn5) {
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		} else if (e.getSource() == p1Label1) {
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			new MainFrame();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
